package com.oldawg.zipcodesample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oldawg.zipcodesample.R
import com.oldawg.zipcodesample.models.ZipCode
import com.oldawg.zipcodesample.viewmodels.ZipCodesViewModel
import kotlinx.android.extensions.LayoutContainer


class ZipCodeAdapter(val viewModel: ZipCodesViewModel) :
    RecyclerView.Adapter<ZipCodeAdapter.ZipCodeViewHolder>() {

    var codes = mutableListOf<ZipCode>()

    fun setZipCodes(codes: List<ZipCode>) {
        this.codes = codes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZipCodeViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.card_zip_code, parent, false)

        return ZipCodeViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ZipCodeViewHolder, position: Int) {
        val item: ZipCode = codes.get(position);
        holder.zipCodeView.text = item.zip_code
        holder.distanceView.text = item.distance.toString()
        holder.cityStateView.text = "${item.city}, ${item.state}"
    }

    override fun getItemCount(): Int {
        return codes.size
    }

    open inner class ZipCodeViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        var zipCodeView: TextView
        var distanceView: TextView
        var cityStateView: TextView

        init {
            zipCodeView = containerView.findViewById(R.id.text_zip_code)
            distanceView = containerView.findViewById(R.id.text_distance)
            cityStateView = containerView.findViewById(R.id.text_city_state)
        }
    }

}