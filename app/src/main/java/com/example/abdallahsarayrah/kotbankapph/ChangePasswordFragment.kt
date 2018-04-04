package com.example.abdallahsarayrah.kotbankapph


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_change_password.*


/**
 * A simple [Fragment] subclass.
 */
class ChangePasswordFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_change_password, container, false)
        var changePasswordOld = view.findViewById<EditText>(R.id.change_password_old)
        var signUpSignUp = view.findViewById<TextView>(R.id.signUp_signUp)

        var bankDB = BankDB(activity)
        var bankDBObj = bankDB.writableDatabase

        signUpSignUp.setOnClickListener {
            var bankDBCursor = bankDBObj.rawQuery("select password from users where email = ? and password = ?", arrayOf(Users.email, changePasswordOld.text.toString()))
            bankDBCursor.moveToFirst()
            if (bankDBCursor.count > 0) {
                if (change_password_new.text.toString() == change_password_confirm.text.toString()) {
                    bankDBObj.execSQL("update users set password = ? where email = ?", arrayOf(change_password_new.text.toString(), Users.email))
                    Toast.makeText(activity, "Password changed", Toast.LENGTH_SHORT).show()
                } else Toast.makeText(activity, "password not match", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(activity, "Old password not correct", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}// Required empty public constructor
