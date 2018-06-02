package com.marton.tamas.curveappchallange.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.marton.tamas.curveappchallange.R
import com.marton.tamas.curveappchallange.common.*
import kotlinx.android.synthetic.main.activity_flash_selector.*


class FlashSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_selector)

        handler_btn.setOnClickListener {
            startSummarizeActivity(HANDLER, (it as Button).text)
        }
        timer_btn.setOnClickListener {
            startSummarizeActivity(TIMER, (it as Button).text)
        }
        rx_btn.setOnClickListener {
            startSummarizeActivity(RXJAVA, (it as Button).text)
        }
        rx_scheduler_btn.setOnClickListener {
            startSummarizeActivity(RXJAVA_SCHEDULER, (it as Button).text)
        }
        animation_btn.setOnClickListener {
            startSummarizeActivity(ANIMATION, (it as Button).text)
        }
    }

    private fun startSummarizeActivity(flashingMode: Int, title: CharSequence) {
        startActivity(Intent(this, SummarizeActivity::class.java).apply {
            putExtra(FLASHING_MODE, flashingMode)
            putExtra(FLASHING_MODE_TITLE, title)
        })
    }
}