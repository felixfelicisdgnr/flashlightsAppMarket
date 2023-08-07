package com.doganur.flashlightappsmarket.ui.coloredLights

import android.content.Intent
import android.net.Uri
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

        coloredLightsAdapter.onColoredLightsProductClick = {

            val intent = requireActivity().packageManager.getLaunchIntentForPackage(it)

            if (intent != null) {
                startActivity(intent)
            } else {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://play.google.com/store/apps/details?id=$it")
                    setPackage("com.android.vending")
                    startActivity(this)
                }
            }
        }

        viewModel.coloredLightsLiveData.observe(viewLifecycleOwner) {
            coloredLightsAdapter.submitList(it)
        }

        viewModel.getColoredLights()
    }
}