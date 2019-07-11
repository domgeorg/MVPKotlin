package gr.mobile.mvp.kotlin.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import gr.mobile.mvp.kotlin.ui.activity.articles.ArticlesActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, ArticlesActivity::class.java)
        startActivity(intent)
        finish()
    }
}