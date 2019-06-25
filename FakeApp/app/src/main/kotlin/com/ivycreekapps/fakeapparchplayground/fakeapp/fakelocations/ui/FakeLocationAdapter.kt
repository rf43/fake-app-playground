package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_location_item.view.*
import kotlin.properties.Delegates

class FakeLocationsAdapter : RecyclerView.Adapter<FakeLocationsAdapter.ViewHolder>() {

    var items: List<FakeLocation> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.view_location_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(location: FakeLocation) {
            with(location) {
                containerView.locationCoordinates.text = coordinates
                containerView.locationDate.text = date
            }
        }
    }
}