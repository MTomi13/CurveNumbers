package com.marton.tamas.curveappchallange.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marton.tamas.curveappchallange.R
import com.marton.tamas.curveappchallange.common.FLASHING_MODE
import com.marton.tamas.curveappchallange.common.HANDLER
import com.marton.tamas.curveappchallange.common.RXJAVA
import com.marton.tamas.curveappchallange.common.TIMER
import kotlinx.android.synthetic.main.activity_flash_selector.*


class FlashSelectorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_selector)

        handler_btn.setOnClickListener {
            startSummarizeActivity(HANDLER)
        }
        timer_btn.setOnClickListener {
            startSummarizeActivity(TIMER)
        }
        rx_btn.setOnClickListener {
            startSummarizeActivity(RXJAVA)
        }
    }

    private fun startSummarizeActivity(flashingMode: Int) {
        startActivity(Intent(this, SummarizeActivity::class.java).apply {
            putExtra(FLASHING_MODE, flashingMode)
        })
    }
}