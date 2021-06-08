package com.example.encoratask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.encoratask.R
import com.example.encoratask.data.model.RickMortyCharacterDetail
import kotlinx.android.synthetic.main.character_list_item.view.*

class RickMortyCharactersAdapter(
    private var charactersList: List<RickMortyCharacterDetail>,
    private val clickListener: (RickMortyCharacterDetail) -> Unit
) : RecyclerView.Adapter<RickMortyCharactersAdapter
.RickMortyCharacterItemViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickMortyCharacterItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_list_item, parent, false)
        return RickMortyCharacterItemViewHolder(itemView, clickListener)
    }

    override fun onBindViewHolder(holder: RickMortyCharacterItemViewHolder, position: Int) {
        holder.bindCharacters(charactersList[position])
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    fun updateList(characterList: List<RickMortyCharacterDetail>) {
        charactersList = characterList
        notifyDataSetChanged()
    }

    class RickMortyCharacterItemViewHolder(
        itemView: View,
        private val clickListener: (RickMortyCharacterDetail) -> Unit
    ) :
        RecyclerView.ViewHolder(itemView) {
        private val characterImage: ImageView = itemView.characterImage
        private val characterName: TextView = itemView.characterName

        fun bindCharacters(character: RickMortyCharacterDetail) {
            with(character) {
                characterName.text = name
                characterImage.load(image)
                itemView.setOnClickListener {
                    clickListener(character)
                }
            }
        }
    }

}