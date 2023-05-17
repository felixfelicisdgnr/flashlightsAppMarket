package com.doganur.flashlightappsmarket.ui.sosalerts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.doganur.flashlightappsmarket.data.model.SosAlertsItem
import com.doganur.flashlightappsmarket.databinding.SosalertsItemBinding

class SosAlertsAdapter :
    ListAdapter<SosAlertsItem, SosAlertsAdapter.SosAlertsViewHolder>(SosAlertsDiff()) {

    var onSosAlertsProductClick: (String) -> Unit = {}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SosAlertsAdapter.SosAlertsViewHolder {
        return SosAlertsViewHolder(SosalertsItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SosAlertsAdapter.SosAlertsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SosAlertsViewHolder(private val binding: SosalertsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productSosAlerts: SosAlertsItem) {

            with(binding) {
                tvNameSosAlerts.text = productSosAlerts.name
                tvCategorySosAlerts.text = productSosAlerts.category
                tvDownloadValueSosAlerts.text = productSosAlerts.downloads + " Mn"
                tvStarValueSosAlerts.text = productSosAlerts.ratingValue.toString()
                tvRatingCountSosAlerts.text = productSosAlerts.ratingCount.toString()

                Glide.with(binding.imgItemSosAlerts).load(productSosAlerts.iconUrl)
                    .into(binding.imgItemSosAlerts)

                root.setOnClickListener { onSosAlertsProductClick(productSosAlerts.packageName?: "") }
            }
        }
    }

    class SosAlertsDiff : DiffUtil.ItemCallback<SosAlertsItem>() {
        override fun areItemsTheSame(oldItem: SosAlertsItem, newItem: SosAlertsItem): Boolean {
            return oldItem.packageName == newItem.packageName
        }

        override fun areContentsTheSame(oldItem: SosAlertsItem, newItem: SosAlertsItem): Boolean {
            return oldItem == newItem
        }
    }
}