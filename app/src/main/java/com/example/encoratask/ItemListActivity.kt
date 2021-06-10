package com.example.encoratask

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.encoratask.adapter.SimpleItemRecyclerViewAdapter
import com.example.encoratask.model.Character
import com.example.encoratask.service.CharacterService

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [ItemDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class ItemListActivity : AppCompatActivity(), View.OnClickListener {

    var characters:ArrayList<Character>? = null

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        this.getCharacters()
    }

    private fun getCharacters() {

        CharacterService.getCharacters(this, {response ->
            characters = Character.parse(response)
            setupRecyclerView()
        },
        {error ->
            Toast.makeText(this, error.localizedMessage, Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecyclerView() {

        val recyclerView:RecyclerView = findViewById(R.id.item_list)
        val adapter = SimpleItemRecyclerViewAdapter(this.characters!!)
        adapter.onClickListener = this
        recyclerView.adapter = adapter
    }

    // -- Click Listener
    override fun onClick(v: View?) {

        val character = v?.tag as Character
        val intent = Intent(v.context, ItemDetailActivity::class.java).apply {
            putExtra(ItemDetailFragment.ARG_ITEM, character)
        }
        v.context.startActivity(intent)
    }
}