package com.doganur.flashlightappsmarket.ui.sosalerts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.flashlightappsmarket.common.RetrofitInstance
import com.doganur.flashlightappsmarket.data.model.SosAlerts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SosAlertsViewModel : ViewModel() {

    private var sosAlertsLiveData = MutableLiveData<SosAlerts>()

    fun getSosAlerts() {

        RetrofitInstance.api.getSosAlerts().enqueue(object : Callback<SosAlerts>{
            override fun onResponse(call: Call<SosAlerts>, response: Response<SosAlerts>) {
                if (response.body() != null){
                    val productSosAlerts : SosAlerts? = response.body()
                    productSosAlerts?.let {
                        sosAlertsLiveData.value = it
                    }
                    Log.d("ColoredDoga", "${productSosAlerts}")
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<SosAlerts>, t: Throwable) {
                Log.d(" Fail Sos Alerts View Model", t.message.toString())
            }
        })
    }

    fun observeSosAlertsLiveData() : LiveData<SosAlerts>{
        return sosAlertsLiveData
    }
}

