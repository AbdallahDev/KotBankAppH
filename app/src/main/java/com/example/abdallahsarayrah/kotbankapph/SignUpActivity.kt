package com.example.abdallahsarayrah.kotbankapph

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUp_signUp.setOnClickListener {
            if (signUp_email.text.isNotEmpty()) {
                var bankDB = BankDB(this)
                var bankDBObj = bankDB.writableDatabase
                var bankDBCursor = bankDBObj.rawQuery("select * from users where email = ?", arrayOf(signUp_email.text.toString()))
                if (bankDBCursor.count == 0) {//this means there is no users with the same email
                    if ((signUp_password.text.toString() == signUp_confirm.text.toString()) && signUp_name.text.isNotEmpty()) {
                        bankDBObj.execSQL("insert into users values(?, ?, ?, 0)", arrayOf(signUp_email.text.toString(), signUp_password.text.toString(), signUp_name.text.toString()))

                        Users.email = signUp_email.text.toString()

                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else Toast.makeText(this, "Please make sure all the data is correct", Toast.LENGTH_SHORT).show()
                } else Toast.makeText(this, "the chosen email is preserved", Toast.LENGTH_SHORT).show()
            }
        }
    }
}