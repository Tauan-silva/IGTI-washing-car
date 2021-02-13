package com.tauan.igticarwashing.presentation.layout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.tauan.igticarwashing.R
import com.tauan.igticarwashing.data.infra.ConstantsApp
import com.tauan.igticarwashing.data.infra.SecurityPreferences

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        securityPreferences = SecurityPreferences(this)
        securityPreferences.storeBoolean(ConstantsApp.KEY.FIRST_ACESS, false)

        Handler().postDelayed(
            {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }, 2000
        )

    }

}