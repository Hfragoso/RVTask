package com.example.encoratask.model

import org.json.JSONObject
import java.io.Serializable

/**
 * Created by Erick Sanchez
 * Revision 1 - 09/06/21
 */
class Character:Serializable {

    var id:Int = 0
    var name:String = ""
    var status = ""
    var species = ""
    var gender = ""
    var image:String = ""

    constructor(obj:JSONObject) {

        this.id = obj.optInt("id")
        this.name = obj.optString("name")
        this.status = obj.optString("status")
        this.species = obj.optString("species")
        this.gender = obj.optString("gender")
        this.image = obj.optString("image")
    }

    companion object {

        fun parse(response:String) : ArrayList<Character> {

            var characters = ArrayList<Character>()
            val obj = JSONObject(response)
            val results = obj.optJSONArray("results")
            if (results != null) {

                for (i in 0 until results.length()) {
                    val temp = results.optJSONObject(i)
                    characters.add(Character(temp))
                }
            }
            return characters
        }
    }
}