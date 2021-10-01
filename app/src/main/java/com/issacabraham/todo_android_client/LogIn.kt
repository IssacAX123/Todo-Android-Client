package com.issacabraham.todo_android_client

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.issacabraham.todo_android_client.api.Request
import org.json.JSONObject

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogIn = findViewById<Button>(R.id.btnLogInOnPage)
        var fieldList = listOf<EditText>(edtEmail, edtPassword)
        var fieldMap = hashMapOf<String, String>("email" to "email", "password" to "password")
        var sendJSON = JSONObject()
        var key : String
        btnLogIn.setOnClickListener{
            var errors = false
            for (field in fieldList){
                if (!field.text.toString().isEmpty()){
                    key = fieldMap.get(field.getTag().toString()).toString()
                    sendJSON.put(key , field.text.toString())
                    field.setBackgroundColor(Color.parseColor("#FFFFFF"))
                }else{
                    errors = true
                    field.setBackgroundColor(Color.parseColor("#ba5757"))
                }
            }
            if (!errors){
                print(sendJSON.toString())
                val user = Request.getUser(sendJSON)
                val intent = Intent(this, MainApp::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
    }
}