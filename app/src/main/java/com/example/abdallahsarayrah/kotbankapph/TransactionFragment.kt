package com.example.abdallahsarayrah.kotbankapph


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast


/**
 * A simple [Fragment] subclass.
 */
class TransactionFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_transaction, container, false)
        var transAmount = view.findViewById<EditText>(R.id.trans_amount)
        var transDeposit = view.findViewById<RadioButton>(R.id.trans_deposit)
        var transSubmit = view.findViewById<TextView>(R.id.trans_submit)

        transSubmit.setOnClickListener {
            var bankDB = BankDB(activity)
            var bankDBObj = bankDB.writableDatabase

            if (transDeposit.isChecked) {
                bankDBObj.execSQL("insert into trans values(?, ?, ?)", arrayOf(Users.email, transAmount.text.toString(), "Deposit"))
                bankDBObj.execSQL("update users set credit = credit + ? where email = ?", arrayOf(transAmount.text.toString(), Users.email))
                Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show()
            } else {
                bankDBObj.execSQL("insert into trans values(?, ?, ?)", arrayOf(Users.email, transAmount.text.toString(), "Withdraw"))

                var bankDBCursor = bankDBObj.rawQuery("select credit from users where email = ?", arrayOf(Users.email))
                bankDBCursor.moveToFirst()
                if (bankDBCursor.getInt(bankDBCursor.getColumnIndex("credit")) >= transAmount.text.toString().toInt()) {
                    bankDBObj.execSQL("update users set credit = credit - ? where email = ?", arrayOf(transAmount.text.toString(), Users.email))
                    Toast.makeText(activity, "Done", Toast.LENGTH_SHORT).show()
                } else Toast.makeText(activity, "Credit not sufficient", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

}// Required empty public constructor
