package com.marton.tamas.curveappchallange.flash

import android.arch.lifecycle.MutableLiveData
import android.os.Handler


class FlashingHandler {
    val FLASH_PERIOD = 500L

    var doFlashing: MutableLiveData<Boolean> = MutableLiveData()

    private val handler = Handler()
    private val flashingRunnable = object : Runnable {
        override fun run() {
            doFlashing.value = true

            handler.postDelayed(this, FLASH_PERIOD)
        }
    }

    fun startFlashing() {
        handler.post(flashingRunnable)
    }
}