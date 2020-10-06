package com.mustafadincay.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    var runnable: Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start (view: View) {
        count = 0
        runnable = object : Runnable{
            override fun run() {
                count++
                textView.text = "Count: ${count}"
                handler.postDelayed(runnable, 1000)
            }
        }
        handler.post (runnable)
    }

    fun stop (view: View) {
        handler.removeCallbacks(runnable)
        count = 0
        textView.text = "Count: ${count}"
    }

}