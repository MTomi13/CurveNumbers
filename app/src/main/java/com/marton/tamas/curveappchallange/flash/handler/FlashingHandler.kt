package com.marton.tamas.curveappchallange.flash.handler

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.marton.tamas.curveappchallange.common.FLASH_PERIOD
import com.marton.tamas.curveappchallange.flash.FlashingActions


class FlashingHandler(private val doFlashing: MutableLiveData<Boolean>) : FlashingActions {

    private val handler = Handler()
    private val flashingRunnable = object : Runnable {
        override fun run() {
            doFlashing.value = true
            handler.postDelayed(this, FLASH_PERIOD)
        }
    }

    override fun startFlashing() {
        handler.post(flashingRunnable)
    }

    override fun stopFlashing() {
        handler.removeCallbacks(flashingRunnable)
    }
}