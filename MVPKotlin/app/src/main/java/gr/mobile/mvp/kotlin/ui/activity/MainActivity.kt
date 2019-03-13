package gr.mobile.mvp.kotlin.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gr.mobile.mvp.kotlin.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
