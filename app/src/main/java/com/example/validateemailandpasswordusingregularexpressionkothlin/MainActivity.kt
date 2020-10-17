package com.example.validateemailandpasswordusingregularexpressionkothlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

   lateinit var  tv_email : TextInputLayout
   lateinit var  tv_username : TextInputLayout
   lateinit var  tv_password : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_email=findViewById(R.id.text_input_email);
        tv_username=findViewById(R.id.text_input_username);
        tv_password=findViewById(R.id.text_input_password);

    }

     fun confirmInput(v:View) {

        if(!validateEmail() || !validateUserName() || !validatePassword()){

            validateEmail()
            validatePassword()
            validateUserName()
            Toast.makeText(this@MainActivity,"Sorry...",Toast.LENGTH_SHORT).show()

        }
        else{

            Toast.makeText(this@MainActivity,"Ok...",Toast.LENGTH_SHORT).show()

        }

    }

    private fun validateEmail() : Boolean{

        if(tv_email.editText!!.text.toString().trim().isEmpty()){
            tv_email.error="Field can't be empty"
            return false

        }else if(!Patterns.EMAIL_ADDRESS.matcher(tv_email.editText!!.text.toString().trim()).matches()){
            tv_email.error="Please enter a valid email address"
            return false
        }
        else{
            tv_email.error=""
            return true
        }

    }

    private fun validateUserName() : Boolean{

        if(tv_username.editText!!.text.toString().trim().isEmpty()){
            tv_username.error="Field can't be empty"
            return false

        }else if(tv_username.editText!!.text.toString().length<5){
            tv_username.error="Username is too short"
            return false
        }
        else{
            tv_username.error=""
            return true
        }

    }

    private fun validatePassword() : Boolean{

        if(tv_password.editText!!.text.toString().trim().isEmpty()){
            tv_password.error="Field can't be empty"
            return false

        }else if(!PASSWORD_PATTERN.matcher(tv_password.editText!!.text.toString().trim()).matches()){
            tv_password.error="User Proper Password Pattern"+tv_password.editText!!.text.toString()
            return false
        }
        else{
            tv_password.error=""
            return true
        }

    }



    companion object{
         val PASSWORD_PATTERN  = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$");
    }
}
