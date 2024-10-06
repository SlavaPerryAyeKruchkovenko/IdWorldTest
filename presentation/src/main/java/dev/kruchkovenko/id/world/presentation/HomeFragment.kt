package dev.kruchkovenko.id.world.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.kruchkovenko.id.world.presentation.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var _binding: FragmentHomeBinding
    val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        this._binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}
