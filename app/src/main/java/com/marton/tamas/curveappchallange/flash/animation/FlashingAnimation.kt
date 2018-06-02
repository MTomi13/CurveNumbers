package com.marton.tamas.curveappchallange.flash.animation

import com.marton.tamas.curveappchallange.flash.FlashingActions


class FlashingAnimation(private val animationCallBack: AnimationCallBack) : FlashingActions {

    override fun startFlashing() {
        animationCallBack.startFlashingAnimation()
    }

    override fun stopFlashing() {
        animationCallBack.stopFlashingAnimation()
    }
}