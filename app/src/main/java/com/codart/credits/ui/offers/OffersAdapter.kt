package com.codart.credits.ui.offers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.data.entities.Offer

class OffersAdapter(private val listener: CharacterItemListener) : RecyclerView.Adapter<OffersViewHolder>() {

    interface CharacterItemListener {
        fun onClickedCharacter(id: Int)
    }

    private val items = ArrayList<Offer>()

    fun setItems(items: ArrayList<Offer>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): OffersViewHolder {
        return OffersViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.cell_offer,
                viewGroup,
                false
        ), listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) = holder.bind(items[position])
}

class OffersViewHolder(itemView: View, private val listener: OffersAdapter.CharacterItemListener) : RecyclerView.ViewHolder(
        itemView),
        View.OnClickListener {

    private lateinit var offer: Offer

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: Offer) {
        this.offer = item
        itemView.findViewById<TextView>(R.id.offer_txt_loan).text = item.name
    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(offer.product_id)
    }
}
