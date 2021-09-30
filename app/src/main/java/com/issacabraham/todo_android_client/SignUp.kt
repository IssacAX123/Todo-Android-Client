package com.issacabraham.todo_android_client

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONObject

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val edtFirstName = findViewById<EditText>(R.id.edtFirstName)
        val edtLastName = findViewById<EditText>(R.id.edtLastName)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUpOnPage)
        var fieldList = listOf<EditText>(edtFirstName, edtLastName, edtEmail, edtPassword)
        var fieldMap = hashMapOf<String, String>("edtFirstName" to "first_name", "edtLastName" to "last_name", "edtEmail" to "email", "edtPassword" to "password")
        var sendJSON = JSONObject()
        var key : String
        btnSignUp.setOnClickListener{
            var errors = false
            for (field in fieldList){
                if (!field.text.toString().isEmpty()){
                    key = fieldMap.get(field.id.toString()).toString()
                    sendJSON.put(key , field.text.toString())
                    field.setBackgroundColor(Color.parseColor("#FFFFFF"))
                }else{
                    errors = true
                    field.setBackgroundColor(Color.parseColor("#ba5757"))
                }
            }
        }
    }
}