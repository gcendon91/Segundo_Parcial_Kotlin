package com.gcendon.a2doparcial

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(private val fruits: List<Fruit>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    lateinit var onItemClickListener: (Fruit) -> Unit

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val tvNombre: TextView = view.findViewById(R.id.tvName)

        fun bind(fruit: Fruit) {
            tvNombre.text = fruit.name

            view.setOnClickListener {
                onItemClickListener(fruit)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false))

    }

    override fun getItemCount(): Int {
        return fruits.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruits[position]
        holder.bind(fruit)
    }
}