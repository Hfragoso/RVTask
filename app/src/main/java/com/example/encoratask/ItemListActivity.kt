package com.example.encoratask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.encoratask.adapter.SimpleItemRecyclerViewAdapter
import com.example.encoratask.viewmodel.CharacterListViewModel

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        setupRecyclerView(findViewById(R.id.item_list))
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val characterList = ViewModelProviders.of(this).get(CharacterListViewModel::class.java)
        characterList.getCharacterList().observe(this, Observer { characterList -> characterList?.let {
            if(characterList != null){
                recyclerView.adapter = SimpleItemRecyclerViewAdapter(characterList.results)
            }
        } })

    }


}