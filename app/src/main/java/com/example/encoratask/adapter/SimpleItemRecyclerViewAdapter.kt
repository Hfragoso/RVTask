package com.example.encoratask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.encoratask.ItemDetailFragment
import com.example.encoratask.R
import com.example.encoratask.model.Character

class SimpleItemRecyclerViewAdapter(private val values: List<Character>) :
    RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Character
            val fragmentDialog = ItemDetailFragment.newInstance(item.id)
            val activity  = v.context as? AppCompatActivity
            fragmentDialog.show(activity?.supportFragmentManager!!, null)
            /*val activity  = v.context as? AppCompatActivity
            val transaction = activity?.supportFragmentManager!!.beginTransaction()
            transaction.replace(R.id.dialogFragment, ItemDetailFragment.newInstance(item.id))
            transaction.commit()*/
            /*val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
                putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id)
            }
            v.context.startActivity(intent)*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameCharacter.text = item.name
        holder.statusCharacter.text = item.status

        Glide.with(holder.itemView)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(holder.imageCharacter)

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameCharacter: TextView = view.findViewById(R.id.name)
        val statusCharacter: TextView = view.findViewById(R.id.status)
        val imageCharacter: ImageView = view.findViewById(R.id.image_character)
    }
}