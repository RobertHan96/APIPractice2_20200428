package com.nexon.apipractice2_20200428.datas

import org.json.JSONObject
import java.util.*

class User {
    var id : Int = 0
    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""

//    JSON 파싱 응용이 필요한 부분
    var storeCategory = Category()
    var createdAt = Calendar.getInstance()

// JSONObject를 User클래스 객체로 파싱하는 함수
    companion object {
        fun getUserFromJsonObject(json : JSONObject) : User {
            val parsedUser = User()
            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            return  parsedUser
        }
    }
}