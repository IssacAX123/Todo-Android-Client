package com.issacabraham.todo_android_client.api

import okhttp3.*
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException
import okhttp3.RequestBody


object Request{
    var mainUrl = "http://10.0.2.2:5000/api/v1"

    var client = OkHttpClient()

    val JSON = MediaType.parse("application/json; charset=utf-8")


    fun getUser(email: String, jsonObject: JSONObject){
        val body: RequestBody = RequestBody.create(JSON, jsonObject.toString())
        val request = Request.Builder().url("$mainUrl/user/$email").post(body).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.toString())
            }

        })

    }

    fun postUser(jsonObject: JSONObject){
        val body: RequestBody = RequestBody.create(JSON, jsonObject.toString())
        val request = Request.Builder().url("$mainUrl/user/create").post(body).build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }

            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.toString())
            }

        })
    }

}