package com.example.encoratask.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.encoratask.R
import com.example.encoratask.data.model.RickMortyCharacterDetail
import com.example.encoratask.ui.adapter.RickMortyCharactersAdapter
import com.example.encoratask.ui.viewmodel.CharacterListViewModel

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [CharacterDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class CharacterListActivity : AppCompatActivity() {
    private lateinit var charactersAdapter: RickMortyCharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        val model: CharacterListViewModel by viewModels()

        model.onCreate()

        setupCharacterList(findViewById(R.id.characterlist))

        observeCharacterList(model)
    }

    private fun setupCharacterList(recyclerView: RecyclerView) {
        charactersAdapter = RickMortyCharactersAdapter(ArrayList()) { character ->
            displayCharacterDetails(character)
        }
        recyclerView.adapter = charactersAdapter
    }

    private fun observeCharacterList(model: CharacterListViewModel) {
        val characterListObserver = Observer<List<RickMortyCharacterDetail>> { characterList ->
            charactersAdapter.updateList(characterList)
        }
        model.characterList.observe(this, characterListObserver)
    }

    private fun displayCharacterDetails(character: RickMortyCharacterDetail) {
        val context = this@CharacterListActivity
        val intent = Intent(context, CharacterDetailActivity::class.java).apply {
            putExtra(CharacterDetailFragment.ARG_ITEM_ID, character.id)
        }
        context.startActivity(intent)
    }
}