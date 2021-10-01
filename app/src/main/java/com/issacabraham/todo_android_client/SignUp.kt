package com.issacabraham.todo_android_client

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.issacabraham.todo_android_client.api.Request
import org.json.JSONObject

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val edtFirstName = findViewById<EditText>(R.id.edtFirstName)
        val edtLastName = findViewById<EditText>(R.id.edtLastName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        var fieldList = listOf<EditText>(edtFirstName, edtLastName, edtEmail, edtPassword)
        var fieldMap = hashMapOf<String, String>("First Name" to "first_name", "Last Name" to "last_name", "email" to "email", "password" to "password")
        var sendJSON = JSONObject()
        var key : String
        btnSignUp.setOnClickListener{
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
                Request.postUser(sendJSON)
                val intent = Intent(this, LogIn::class.java)
                startActivity(intent)
            }
        }
    }
}