package com.doganur.flashlightappsmarket.ui.sosalerts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentSosAlertsBinding

class SosAlertsFragment : Fragment(R.layout.fragment_sos_alerts) {

    private val binding by viewBinding(FragmentSosAlertsBinding::bind)

    private val viewModel : SosAlertsViewModel by viewModels()

    private lateinit var sosAlertsAdapter : SosAlertsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sosAlertsAdapter = SosAlertsAdapter()
        binding.rvSosAlerts.adapter = sosAlertsAdapter

        viewModel.observeSosAlertsLiveData().observe(viewLifecycleOwner) {sosAlerts ->
            sosAlertsAdapter.submitList(sosAlerts)
        }

        viewModel.getSosAlerts()
    }
}