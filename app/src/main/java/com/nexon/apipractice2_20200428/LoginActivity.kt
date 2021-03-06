package com.nexon.apipractice2_20200428

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.nexon.apipractice2_20200428.datas.User
import com.nexon.apipractice2_20200428.utils.ConectServer
import com.nexon.apipractice2_20200428.utils.ContextUtil
import com.nexon.apipractice2_20200428.utils.GlobalData
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {
        loginBtn.setOnClickListener {
            val id = idEdt.text.toString()
            val pw = pwEdt.text.toString()

            ConectServer.postRequestLogin(mContext, id, pw, object : ConectServer.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("결과", json.toString())
                    val code = json.getInt("code")

                    if (code == 200) {
                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")
                        val token = data.getString("token")
                        ContextUtil.setUserToken(mContext, token)

                        val nowLoginUser = User.getUserFromJsonObject(user)
                        GlobalData.loginUser = nowLoginUser

                        val myIntent = Intent(mContext, MyPageActivity::class.java)
                        startActivity(myIntent)


                    } else {
                        val message = json.getString("message")
                        runOnUiThread{
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }

            })

        }

    }

    override fun setValues() {

    }


}
