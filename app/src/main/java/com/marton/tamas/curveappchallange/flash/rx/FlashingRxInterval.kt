package com.marton.tamas.curveappchallange.flash.rx

import android.arch.lifecycle.MutableLiveData
import com.marton.tamas.curveappchallange.common.FLASH_PERIOD
import com.marton.tamas.curveappchallange.flash.FlashingActions
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


class FlashingRxInterval(private val doFlashing: MutableLiveData<Boolean>) : FlashingRxBase(), FlashingActions {

    override fun startFlashing() {
        compositeDisposable.add(Observable.interval(FLASH_PERIOD, TimeUnit.MILLISECONDS)
                .subscribe { doFlashing.postValue(true) })
    }
}