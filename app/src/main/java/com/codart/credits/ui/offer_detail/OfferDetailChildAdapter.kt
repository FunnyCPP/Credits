package com.codart.credits.ui.offer_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.data.entities.Attribute

class OfferDetailChildAdapter : RecyclerView.Adapter<OfferDetailChildViewHolder>() {

    private val items = ArrayList<Attribute>()

    fun setItems(items: ArrayList<Attribute>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): OfferDetailChildViewHolder {
        return OfferDetailChildViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.cell_offer_detail_child,
                viewGroup,
                false
        ))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: OfferDetailChildViewHolder, position: Int) = holder.bind(items[position])
}

class OfferDetailChildViewHolder(itemView: View) : RecyclerView.ViewHolder(
        itemView){

    private lateinit var group: Attribute
    private var title: TextView = itemView.findViewById(R.id.offer_detail_title_child)

    fun bind(item: Attribute) {
        this.group = item
        title.text = group.name
    }
}