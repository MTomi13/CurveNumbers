package com.marton.tamas.curveappchallange.flash.rx

import com.marton.tamas.curveappchallange.flash.FlashingActions
import io.reactivex.disposables.CompositeDisposable


abstract class FlashingRxBase : FlashingActions {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun stopFlashing() {
        compositeDisposable.clear()
    }
}