package com.doganur.flashlightappsmarket.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val homeMVVM : HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onFlashlightsClick()
        onColoredLightsClick()
        onSosAlertsClick()

        }

    private fun onFlashlightsClick() {
        binding.imgFlashlights.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToFlashlightsFragment()
            findNavController().navigate(action)
        }
    }

    private fun onColoredLightsClick() {
        binding.imgColoredLights.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToColoredLightsFragment()
            findNavController().navigate(action)
        }
    }

    private fun onSosAlertsClick() {
        binding.imgSosAlerts.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSosAlertsFragment()
            findNavController().navigate(action)
        }
    }
}