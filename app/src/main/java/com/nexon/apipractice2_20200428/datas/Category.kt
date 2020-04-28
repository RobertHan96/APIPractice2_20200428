package com.nexon.apipractice2_20200428.datas

import org.json.JSONObject

class Category {
    var id = 0
    var title = ""
    var color = ""

    companion object {
        fun getCategoryFromJson(json : JSONObject) : Category {
            val ct = Category()
            ct.id = json.getInt("id")
            ct.title = json.getString("title")
            ct.color = json.getString("color")
            return  ct
        }
    }

}