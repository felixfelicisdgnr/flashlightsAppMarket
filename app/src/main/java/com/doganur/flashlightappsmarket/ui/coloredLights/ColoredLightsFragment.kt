package com.doganur.flashlightappsmarket.ui.coloredLights

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentColoredLightsBinding

class ColoredLightsFragment : Fragment(R.layout.fragment_colored_lights) {

    private val binding by viewBinding(FragmentColoredLightsBinding::bind)

    private val viewModel: ColoredLightsViewModel by viewModels()

    private lateinit var coloredLightsAdapter: ColoredLightsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coloredLightsAdapter = ColoredLightsAdapter()
        binding.rvColoredLights.adapter = coloredLightsAdapter

        viewModel.observeColoredLightsLiveData().observe(viewLifecycleOwner) { coloredLights ->
            coloredLightsAdapter.submitList(coloredLights)
        }

        viewModel.getColoredLights()
    }
}