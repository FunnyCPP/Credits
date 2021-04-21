package com.codart.credits.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codart.credits.R
import com.codart.credits.data.entities.Category

class CategoriesAdapter(private val listener: CharacterItemListener) : RecyclerView.Adapter<CategoriesViewHolder>() {

    interface CharacterItemListener {
        fun onClickedCharacter(id: Int)
    }

    private val items = ArrayList<Category>()

    fun setItems(items: ArrayList<Category>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(itemView = LayoutInflater.from(viewGroup.context).inflate(
                R.layout.cell_category,
                viewGroup,
                false
        ), listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) = holder.bind(items[position])
}

class CategoriesViewHolder(itemView: View, private val listener: CategoriesAdapter.CharacterItemListener) : RecyclerView.ViewHolder(
        itemView),
        View.OnClickListener {

    private lateinit var category: Category

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: Category) {
        this.category = item
        itemView.findViewById<TextView>(R.id.category_title_1).text = item.name
    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(category.category_id)
    }
}
