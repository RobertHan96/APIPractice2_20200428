package com.nexon.apipractice2_20200428.datas

import java.util.*

class User {
    var id : Int = 0
    var login_id = ""
    var name = ""
    var phoneNum = ""
    var memo = ""

//    JSON 파싱 응용이 필요한 부분
    var storeCategory = Category()
    var createdAt = Calendar.getInstance()


}