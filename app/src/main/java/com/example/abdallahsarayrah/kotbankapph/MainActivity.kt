package com.example.abdallahsarayrah.kotbankapph

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.change_password -> {
                var transaction = fragmentManager.beginTransaction()
                var transactionObj = ChangePasswordFragment()
                transaction.replace(R.id.fragment_container, transactionObj)
                transaction.commit()
            }

            R.id.show_credit -> {
                var transaction = fragmentManager.beginTransaction()
                var transactionObj = ShowCreditFragment()
                transaction.replace(R.id.fragment_container, transactionObj)
                transaction.commit()
            }

            R.id.transactions -> {
                var transaction = fragmentManager.beginTransaction()
                var transactionObj = TransactionFragment()
                transaction.replace(R.id.fragment_container, transactionObj)
                transaction.commit()
            }

            R.id.report -> {
                var transaction = fragmentManager.beginTransaction()
                var transactionObj = ReportFragment()
                transaction.replace(R.id.fragment_container, transactionObj)
                transaction.commit()
            }

            R.id.logout -> {
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
