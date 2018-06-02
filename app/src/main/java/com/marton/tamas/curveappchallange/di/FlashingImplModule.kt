package com.marton.tamas.curveappchallange.di

import android.arch.lifecycle.MutableLiveData
import com.marton.tamas.curveappchallange.flash.animation.FlashingAnimation
import com.marton.tamas.curveappchallange.flash.handler.FlashingHandler
import com.marton.tamas.curveappchallange.flash.rx.FlashingRxInterval
import com.marton.tamas.curveappchallange.flash.rx.FlashingRxSchedulers
import com.marton.tamas.curveappchallange.flash.timer.FlashingTimer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FlashingImplModule {

    @Singleton
    @Provides
    fun provideMutableLiveData(): MutableLiveData<Boolean> {
        return MutableLiveData()
    }

    @Provides
    fun provideFlashingHandlerModule(doFlashing: MutableLiveData<Boolean>): FlashingHandler {
        return FlashingHandler(doFlashing)
    }

    @Provides
    fun provideFlashingRxIntervalModule(doFlashing: MutableLiveData<Boolean>): FlashingRxInterval {
        return FlashingRxInterval(doFlashing)
    }

    @Provides
    fun provideFlashingRxSchedulersModule(doFlashing: MutableLiveData<Boolean>): FlashingRxSchedulers {
        return FlashingRxSchedulers(doFlashing)
    }

    @Provides
    fun provideFlashingTimerModule(doFlashing: MutableLiveData<Boolean>): FlashingTimer {
        return FlashingTimer(doFlashing)
    }

    @Provides
    fun provideFlashingAnimationModule(): FlashingAnimation {
        return FlashingAnimation()
    }
}