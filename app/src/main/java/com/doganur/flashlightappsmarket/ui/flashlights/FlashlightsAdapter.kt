package com.doganur.flashlightappsmarket.ui.flashlights

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.flashlightappsmarket.data.model.FlashlightsItem
import com.doganur.flashlightappsmarket.databinding.FlashlightsItemBinding

class FlashlightsAdapter :
    ListAdapter<FlashlightsItem, FlashlightsAdapter.FlashlightsViewHolder>(FlashlightsDiff()) {

    var onFlashLightsProductClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashlightsViewHolder {
        return FlashlightsViewHolder(FlashlightsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FlashlightsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FlashlightsViewHolder(private val binding: FlashlightsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productFlashlights: FlashlightsItem) {
            with(binding) {
                tvNameFlashlights.text = productFlashlights.name
                tvCategoryFlashlights.text = productFlashlights.category
                tvDownloadValueFlashlights.text = productFlashlights.downloads + " Mn"
                tvStarValueFlashlights.text = productFlashlights.ratingValue.toString()
                tvRatingCountFlashlights.text = productFlashlights.ratingCount.toString()

                Glide.with(binding.imgItemFlashlights).load(productFlashlights.iconUrl)
                    .into(binding.imgItemFlashlights)
                root.setOnClickListener {
                    onFlashLightsProductClick(
                        productFlashlights.packageName ?: ""
                    )
                }
            }
        }
    }

    class FlashlightsDiff : DiffUtil.ItemCallback<FlashlightsItem>() {
        override fun areItemsTheSame(oldItem: FlashlightsItem, newItem: FlashlightsItem): Boolean {
            return oldItem.packageName == newItem.packageName
        }

        override fun areContentsTheSame(
            oldItem: FlashlightsItem,
            newItem: FlashlightsItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}