package com.nexon.apipractice2_20200428

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nexon.apipractice2_20200428.utils.GlobalData
import kotlinx.android.synthetic.main.activity_my_page.*

class MyPageActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        nameText.text = GlobalData.loginUser?.name
        phoneText.text = GlobalData.loginUser?.phoneNum



    }

}
