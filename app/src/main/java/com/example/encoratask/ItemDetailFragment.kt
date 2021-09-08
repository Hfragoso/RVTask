package com.example.encoratask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.encoratask.model.Character
import com.example.encoratask.viewmodel.CharacterInfoViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_detail.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : BottomSheetDialogFragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item_id: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item_id = it.getLong(ARG_ITEM_ID)
                //activity?.findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)?.title = item?.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        val characterInfo = ViewModelProviders.of(this).get(CharacterInfoViewModel::class.java)
        characterInfo.getCharacterInfo(item_id!!).observe(this.viewLifecycleOwner, Observer { info -> info?.let {
            if(info != null){
                loadInformation(info)
            }
        }

        })
        // Show the dummy content as text in a TextView.
        /*item?.let {
            rootView.findViewById<TextView>(R.id.item_detail).text = it.details
        }*/

        return rootView
    }

    private fun loadInformation(info: Character){
        item_name.text = info.name
        item_gender.text = info.gender
        item_species.text = info.species
        item_status.text = info.status
        item_type.text = info.type

        Glide.with(this)
            .load(info.image)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(item_image)

    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"

        @JvmStatic
        fun newInstance(item_id: Long?) =
            ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_ITEM_ID, item_id!!)
                }
            }
    }
}