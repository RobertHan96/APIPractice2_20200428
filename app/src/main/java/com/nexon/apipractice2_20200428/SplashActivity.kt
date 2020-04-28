package com.nexon.apipractice2_20200428

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.nexon.apipractice2_20200428.utils.ContextUtil

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        Handler().postDelayed({
            if (ContextUtil.getUserToken(mContext) == "" ) {
                val myIntent = Intent(mContext, LoginActivity::class.java)
                startActivity(myIntent)
                finish()
            } else {
//                유저 토큰이 저장되어있다면 해당 토큰으로 유저정보를 뽑아서 GlobalData클래스에 저장하고 화면 이동

                val myIntent = Intent(mContext, MyPageActivity::class.java)
                startActivity(myIntent)
                finish()
            }
        }, 2500)

    }

}
