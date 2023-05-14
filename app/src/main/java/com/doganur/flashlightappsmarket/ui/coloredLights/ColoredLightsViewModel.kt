package com.doganur.flashlightappsmarket.ui.coloredLights

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.doganur.flashlightappsmarket.common.RetrofitInstance
import com.doganur.flashlightappsmarket.data.model.ColoredLights
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ColoredLightsViewModel : ViewModel() {

    private var coloredLightsLiveData = MutableLiveData<ColoredLights>()

    fun getColoredLights() {

        RetrofitInstance.api.getColoredLights().enqueue(object : Callback<ColoredLights> {
            override fun onResponse(call: Call<ColoredLights>, response: Response<ColoredLights>) {
                if (response.body() != null){
                    val productColoredLights : ColoredLights? = response.body()
                    productColoredLights?.let {
                        coloredLightsLiveData.value = it
                    }
                    Log.d("ColorDoga","deneme ${productColoredLights}")
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<ColoredLights>, t: Throwable) {
                    Log.d("Fail Colored Lights View Model ", t.message.toString())
            }
        })
    }

    fun observeColoredLightsLiveData() : LiveData<ColoredLights>{
        return coloredLightsLiveData
    }
}

