package com.doganur.flashlightappsmarket.ui.coloredLights

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.flashlightappsmarket.data.model.ColoredLightsItem
import com.doganur.flashlightappsmarket.databinding.ColoredlightsItemBinding


class ColoredLightsAdapter : ListAdapter<ColoredLightsItem, ColoredLightsAdapter.ColoredLightsViewHolder>(ColoredLightsDiff()) {

    var onColoredLightsProduct : (ColoredLightsItem) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColoredLightsViewHolder {
        return ColoredLightsViewHolder(ColoredlightsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ColoredLightsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ColoredLightsViewHolder(private val binding : ColoredlightsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productColoredLights : ColoredLightsItem){

            with(binding) {
                tvNameColoredLights.text = productColoredLights.name
                Glide.with(binding.imgColoredLights).load(productColoredLights.iconUrl).into(binding.imgColoredLights)

                root.setOnClickListener { onColoredLightsProduct(productColoredLights) }
            }
        }
    }

    class ColoredLightsDiff : DiffUtil.ItemCallback<ColoredLightsItem>() {
        override fun areItemsTheSame(oldItem: ColoredLightsItem, newItem: ColoredLightsItem): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: ColoredLightsItem, newItem: ColoredLightsItem): Boolean {
            return oldItem == newItem
        }
    }
}