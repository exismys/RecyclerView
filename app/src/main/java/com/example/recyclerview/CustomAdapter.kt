package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val list: List<Item>, private val onItemClick: (position: Int) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(row: View, private val onItemClick: (position: Int) -> Unit) : RecyclerView.ViewHolder(row) {
        val imageView: ImageView = row.findViewById(R.id.imageview)
        val textview1: TextView = row.findViewById(R.id.firsttext)
        val textView2: TextView = row.findViewById(R.id.secondtext)
        private val cardView: CardView = row.findViewById(R.id.cardview)

        init {
            cardView.setOnClickListener { onItemClick(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(row, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.textview1.text = item.text
        holder.textView2.text = item.text2
        holder.imageView.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}