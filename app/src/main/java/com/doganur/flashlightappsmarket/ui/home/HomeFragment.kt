package com.doganur.flashlightappsmarket.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentHomeBinding
import com.doganur.flashlightappsmarket.ui.activities.MainActivity

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            imgSosAlerts.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSosAlertsFragment())
            }
            imgColoredLights.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToColoredLightsFragment())
            }
            imgFlashlights.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFlashlightsFragment())
            }
        }
    }
}