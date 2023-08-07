package com.doganur.flashlightappsmarket.ui.sosalerts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.doganur.flashlightappsmarket.R
import com.doganur.flashlightappsmarket.common.viewBinding
import com.doganur.flashlightappsmarket.databinding.FragmentSosAlertsBinding

class SosAlertsFragment : Fragment(R.layout.fragment_sos_alerts) {

    private val binding by viewBinding(FragmentSosAlertsBinding::bind)

    private val viewModel: SosAlertsViewModel by viewModels()

    private lateinit var sosAlertsAdapter: SosAlertsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sosAlertsAdapter = SosAlertsAdapter()
        binding.rvSosAlerts.adapter = sosAlertsAdapter

        sosAlertsAdapter.onSosAlertsProductClick = {

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

        viewModel.sosAlertsLiveData.observe(viewLifecycleOwner){
            sosAlertsAdapter.submitList(it)
        }
        viewModel.getSosAlerts()
    }
}