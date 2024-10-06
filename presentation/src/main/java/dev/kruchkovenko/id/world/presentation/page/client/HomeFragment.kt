package dev.kruchkovenko.id.world.presentation.page.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.kruchkovenko.id.world.presentation.R
import dev.kruchkovenko.id.world.presentation.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var _binding: FragmentHomeBinding
    val binding get() = _binding
    private val viewModel: ClientViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        this._binding = FragmentHomeBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.loader.visibility = View.GONE
        binding.operatorName.visibility = View.VISIBLE
        binding.operatorName.text = viewModel.clientName()
    }
}
