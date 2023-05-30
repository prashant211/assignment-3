package com.prashant.dummy3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.prashant.dummy3.R

class MainActivity : AppCompatActivity() {
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent= Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}