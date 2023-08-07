package com.doganur.flashlightappsmarket.ui.flashlights

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.flashlightappsmarket.common.RetrofitInstance
import com.doganur.flashlightappsmarket.data.model.Flashlights
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlashlightsViewModel : ViewModel() {

    val flashlightsLiveData = MutableLiveData<Flashlights>()

    fun getFlashLights() {
        RetrofitInstance.api.getFlashlights().enqueue(object : Callback<Flashlights> {
            override fun onResponse(call: Call<Flashlights>, response: Response<Flashlights>) {
                if (response.body() != null) {
                    val productFlashlights: Flashlights? = response.body()
                    productFlashlights?.let {
                        flashlightsLiveData.value = it
                    }
                } else {
                    return
                }
            }
            override fun onFailure(call: Call<Flashlights>, t: Throwable) {
                Log.d("Fail Flashlights View Model", t.message.toString())
            }
        })
    }
}