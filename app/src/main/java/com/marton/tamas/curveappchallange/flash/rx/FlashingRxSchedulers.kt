package com.marton.tamas.curveappchallange.flash.rx

import android.arch.lifecycle.MutableLiveData
import com.marton.tamas.curveappchallange.common.FLASH_PERIOD
import com.marton.tamas.curveappchallange.flash.FlashingActions
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class FlashingRxSchedulers(private val doFlashing: MutableLiveData<Boolean>) : FlashingRxBase(), FlashingActions {

    override fun startFlashing() {
        compositeDisposable.add(Schedulers.newThread()
                .schedulePeriodicallyDirect({ doFlashing.postValue(true) }, FLASH_PERIOD, FLASH_PERIOD, TimeUnit.MILLISECONDS))
    }
}