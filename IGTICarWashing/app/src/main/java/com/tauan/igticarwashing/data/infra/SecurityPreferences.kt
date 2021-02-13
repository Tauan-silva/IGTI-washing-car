package com.tauan.igticarwashing.data.infra

import android.content.Context

class SecurityPreferences(context: Context) {

    private val mSharedPreferences = context.getSharedPreferences("sharedPreferences app", Context.MODE_PRIVATE)

    fun storeBoolean(key : String, value : Boolean){
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String){
        TODO()
    }
}