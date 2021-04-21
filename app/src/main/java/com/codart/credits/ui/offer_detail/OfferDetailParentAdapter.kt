package com.codart.credits.ui.offer_detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.data.entities.AttributeGroup

class OfferDetailParentAdapter(val context: Context) : RecyclerView.Adapter<OfferDetailParentViewHolder>() {

    private val items = ArrayList<AttributeGroup>()

    fun setItems(items: ArrayList<AttributeGroup>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): OfferDetailParentViewHolder {
        return OfferDetailParentViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.cell_offer_detail_parent,
                viewGroup,
                false
        ), context)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: OfferDetailParentViewHolder, position: Int) = holder.bind(items[position])
}

class OfferDetailParentViewHolder(itemView: View,val  context: Context) : RecyclerView.ViewHolder(
        itemView){

    private lateinit var group: AttributeGroup
    private var title: TextView = itemView.findViewById(R.id.offer_detail_title_parent)
    private var recyclerView: RecyclerView = itemView.findViewById(R.id.offer_detail_recycler_child)

    fun bind(item: AttributeGroup) {
        this.group = item
        title.text = group.name
        setupRecyclerView(recyclerView)
    }
    private fun setupRecyclerView(recycler: RecyclerView) {
        val adapter = OfferDetailChildAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        adapter.setItems(ArrayList(group.attribute))
        recycler.adapter = adapter

    }
}