package com.example.abdallahsarayrah.kotbankapph


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 */
class ShowCreditFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_show_credit, container, false)
        var showCreditCredit = view.findViewById<TextView>(R.id.show_credit_credit)

        var bankDB = BankDB(activity)
        var bankDBObj = bankDB.readableDatabase
        var bankDBCursor = bankDBObj.rawQuery("select credit from users where email = ?", arrayOf(Users.email))
        bankDBCursor.moveToFirst()
        showCreditCredit.text = bankDBCursor.getString(bankDBCursor.getColumnIndex("credit"))

        return view
    }

}// Required empty public constructor
