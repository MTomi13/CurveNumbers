package com.marton.tamas.curveappchallange.flash.timer

import android.arch.lifecycle.MutableLiveData
import com.marton.tamas.curveappchallange.common.FLASH_PERIOD
import com.marton.tamas.curveappchallange.flash.FlashingActions
import java.util.*


class FlashingTimer(private val doFlashing: MutableLiveData<Boolean>) : FlashingActions {

    private var timer: Timer? = null

    override fun startFlashing() {
        timer = Timer()
        timer?.scheduleAtFixedRate(FlashingTimerTask(), FLASH_PERIOD, FLASH_PERIOD)
    }

    override fun stopFlashing() {
        timer?.cancel()
    }

    private inner class FlashingTimerTask : TimerTask() {
        override fun run() {
            doFlashing.postValue(true)
        }
    }
}