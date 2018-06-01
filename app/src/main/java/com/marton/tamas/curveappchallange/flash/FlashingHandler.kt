package com.marton.tamas.curveappchallange.flash

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.marton.tamas.curveappchallange.common.FLASH_PERIOD


class FlashingHandler {


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