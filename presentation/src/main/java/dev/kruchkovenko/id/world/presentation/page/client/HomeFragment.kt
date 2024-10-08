package dev.kruchkovenko.id.world.presentation.page.client

import android.Manifest
import android.content.Intent
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import dev.kruchkovenko.id.world.presentation.R
import dev.kruchkovenko.id.world.presentation.databinding.FragmentHomeBinding
import dev.kruchkovenko.id.world.presentation.feature.location.util.PermissionUtil.checkGeolocationPermission
import dev.kruchkovenko.id.world.presentation.feature.location.util.PermissionUtil.getLocationManager
import dev.kruchkovenko.id.world.presentation.feature.location.util.PermissionUtil.isLocationEnabled
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var _binding: FragmentHomeBinding
    val binding get() = _binding
    private val viewModel: ClientViewModel by viewModel()
    private val locationListener: LocationListener by inject()

    val launcher =
        registerForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    getLastLocation()
                }

                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    getLastLocation()
                }

                else -> {
                    Toast.makeText(
                        requireContext(), getString(R.string.enable_location), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        this._binding = FragmentHomeBinding.inflate(inflater, container, false)
        initView()
        initLocationContainer()
        return binding.root
    }

    private fun getLastLocation() {
        val context = requireContext()
        if (checkGeolocationPermission(context)) {
            val locationManager = getLocationManager(context)
            if (isLocationEnabled(locationManager)) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, LOCATION_DELAY, MIN_DISTANCE, locationListener
                )
            } else {
                Toast.makeText(context, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            launcher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private fun initView() {
        binding.loader.visibility = View.GONE
        binding.operatorContainer.visibility = View.VISIBLE
        binding.operatorName.text = viewModel.clientName()
    }

    private fun initLocationContainer() {
        viewModel.location.observe(viewLifecycleOwner) {
            binding.operatorLocation.text =
                getString(R.string.location_format, it.latitude, it.longitude)
        }
        if (arguments?.getBoolean(GMS_DISABLE) != true) {
            getLastLocation()
        }
    }

    companion object {
        const val LOCATION_DELAY = 5000L
        const val MIN_DISTANCE = 0.1f
        const val GMS_DISABLE = "gms_disable"

        fun createArgs(gmsDisable: Boolean) = Bundle().apply {
            putBoolean(GMS_DISABLE, gmsDisable)
        }
    }
}
