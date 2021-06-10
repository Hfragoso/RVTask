package com.example.encoratask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.encoratask.R
import com.example.encoratask.model.Character

/**
 * Created by Erick Sanchez
 * Revision 1 - 10/06/21
 */
open class SimpleItemRecyclerViewAdapter(private val values: ArrayList<Character>) :
    RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    init {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = values[position]

        holder.contentView.text = item.name
        holder.metaView.text = "${item.species} - ${item.gender}"
        Glide.with(holder.itemView.context).load(item.image).into(holder.imageView)

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.characterImage)
        val contentView: TextView = view.findViewById(R.id.characterName)
        val metaView: TextView = view.findViewById(R.id.characterMeta)
    }
}