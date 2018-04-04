package com.example.abdallahsarayrah.kotbankapph

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by abdallah.sarayrah on 10/22/2017.
 */

class BankDB(context: Context) : SQLiteOpenHelper(context, "bank.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table users(email text, password text, name text, credit integer)")
        db?.execSQL("create table trans(email text, amount integer, dw text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}