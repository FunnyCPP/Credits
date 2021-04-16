package com.codart.credits.ui.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.data.entities.Country

class CountriesAdapter(private val listener: CharacterItemListener) : RecyclerView.Adapter<CountriesViewHolder>() {

    interface CharacterItemListener {
        fun onClickedCharacter(characterId: Int)
    }

    private val items = ArrayList<Country>()

    fun setItems(items: ArrayList<Country>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.cell_country,
            viewGroup,
            false
        ), listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) = holder.bind(items[position])
}

class CountriesViewHolder(private val itemView: View, private val listener: CountriesAdapter.CharacterItemListener) : RecyclerView.ViewHolder(
    itemView),
    View.OnClickListener {

    private lateinit var country: Country

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: Country) {
        this.country = item
        itemView.findViewById<TextView>(R.id.country_title).text = item.name
    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(country.country_id)
    }
}
