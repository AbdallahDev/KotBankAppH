package com.example.abdallahsarayrah.kotbankapph


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView


/**
 * A simple [Fragment] subclass.
 */
class ReportFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater!!.inflate(R.layout.fragment_report, container, false)
        var listViewReport = view.findViewById<ListView>(R.id.list_view_report)

        var bankDB = BankDB(activity)
        var bankDBObj = bankDB.readableDatabase
        var bankDBCursor = bankDBObj.rawQuery("select * from trans where email = ?", arrayOf(Users.email))
        bankDBCursor.moveToFirst()
        var arrayListReport = ArrayList<String>()
        while (!bankDBCursor.isAfterLast) {
            arrayListReport.add(bankDBCursor.getInt(bankDBCursor.getColumnIndex("amount")).toString() + " - " + bankDBCursor.getString(bankDBCursor.getColumnIndex("dw")))
            bankDBCursor.moveToNext()
        }
        var adapterReport = ArrayAdapter(activity, R.layout.list_row_report, arrayListReport)
        listViewReport.adapter = adapterReport

        return view
    }

}// Required empty public constructor
