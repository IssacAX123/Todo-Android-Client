package com.issacabraham.todo_android_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.issacabraham.todo_android_client.api.data.User


class MainApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        val intent = intent
        var user: User? = intent.getParcelableExtra<User>("user")
        println(user)
    }
}