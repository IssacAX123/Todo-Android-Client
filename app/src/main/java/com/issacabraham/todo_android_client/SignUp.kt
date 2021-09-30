package com.issacabraham.todo_android_client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

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
        btnSignUp.setOnClickListener{
            for (field in fieldList){
                if (!field.text.getString().isEmpty()){

                }else{
                    Toas
                }
            }
        }
    }
}