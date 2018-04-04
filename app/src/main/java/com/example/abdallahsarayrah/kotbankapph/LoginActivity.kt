package com.example.abdallahsarayrah.kotbankapph

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_login.setOnClickListener {
            if (login_email.text.isNotEmpty()) {
                var bankDB = BankDB(this)
                var bankDBObj = bankDB.readableDatabase
                var bankDBCursor = bankDBObj.rawQuery("select * from users where email = ? and password = ?", arrayOf(login_email.text.toString(), login_password.text.toString()))
                if (bankDBCursor.count > 0)//this means the user with this email and password is exist
                {
                    Users.email = login_email.text.toString()

                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else Toast.makeText(this, "Either the email or the password is incorrect", Toast.LENGTH_SHORT).show()
            }
        }

        login_signUp.setOnClickListener {
            var intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
