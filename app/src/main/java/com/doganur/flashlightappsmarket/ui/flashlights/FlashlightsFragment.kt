package com.doganur.flashlightappsmarket.ui.flashlights

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentFlashlightsBinding

class FlashlightsFragment : Fragment(R.layout.fragment_flashlights) {

    private val binding by viewBinding(FragmentFlashlightsBinding::bind)

    private val viewModel: FlashlightsViewModel by viewModels()

    private lateinit var flashlightsAdapter: FlashlightsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flashlightsAdapter = FlashlightsAdapter()
        binding.rvFlashlights.adapter = flashlightsAdapter

        viewModel.observeFlashlightsLiveData().observe(viewLifecycleOwner) { flashlights ->
            flashlightsAdapter.submitList(flashlights)
        }

        viewModel.getFlashLights()
    }
}