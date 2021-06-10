package com.example.encoratask.service

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/**
 * Created by Erick Sanchez
 * Revision 1 - 10/06/21
 */
open class CharacterService{

    companion object {

        private val apiUrl = "https://rickandmortyapi.com/api"

        fun getCharacters(context:Context, response:Response.Listener<String>, error: Response.ErrorListener) {

            val url = "$apiUrl/character/"
            val mRequestQueue = Volley.newRequestQueue(context)
            val request = StringRequest(Request.Method.GET, url, response, error)
            mRequestQueue.add(request)
        }
    }
}