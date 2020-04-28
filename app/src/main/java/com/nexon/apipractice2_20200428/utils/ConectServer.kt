package com.nexon.apipractice2_20200428.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.json.JSONObject
import java.io.IOException

class ConectServer {
    //    서버통신의 응답내용 (json변수)을 액티비티로 넘겨주기 위한 인터페이스
    interface JsonResponseHandler {
        fun onResponse(json: JSONObject)
    }

    companion object {
        private val BASE_URL = "http://192.168.0.243:5000" // 개발용주소

        fun getRequestMyInfo(context: Context, handler: JsonResponseHandler?) {
            val client = OkHttpClient()
            val urlBuilder = "${BASE_URL}/my_info".toHttpUrlOrNull()!!.newBuilder()
            urlBuilder.addQueryParameter("os", "Android").build()
            val urlString = urlBuilder.build().toString()
            Log.d("완성된 주소", urlString)

            val request = Request.Builder()
                .url(urlString)
                .header("X-Http-Token", ContextUtil.getUserToken(context))
                .build()
            client.newCall(request).enqueue(object  : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val body = response.body!!.string()
                    val json = JSONObject(body)
                    handler?.onResponse(json)
                }

            })
        }

        fun postRequestLogin(context: Context, id:String, pw:String, handler:JsonResponseHandler?) {

                val client = OkHttpClient()
                val urlStr = "${BASE_URL}/auth"

                val formBody = FormBody.Builder()
                    .add("login_id", id)
                    .add("password", pw)
                    .build()


                val request = Request.Builder()
                    .url(urlStr)
                    .post(formBody)
    //                .header()  => API가 헤더를 요구하면 추가해야함.
                    .build()

                client.newCall(request).enqueue(object : Callback {

                    override fun onFailure(call: Call, e: IOException) {
                        e.printStackTrace()
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val body = response.body!!.string()
                        val json = JSONObject(body)

                        handler?.onResponse(json)


                    }

                })


            }

        }

    }
