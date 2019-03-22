package gr.mobile.mvp.kotlin.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gr.mobile.mvp.kotlin.ui.activity.menu.MenuActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }
}