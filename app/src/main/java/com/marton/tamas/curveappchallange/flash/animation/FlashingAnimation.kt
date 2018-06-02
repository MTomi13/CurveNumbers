package com.marton.tamas.curveappchallange.flash.animation

import com.marton.tamas.curveappchallange.flash.FlashingActions


class FlashingAnimation : FlashingActions {

    var animationCallBack: AnimationCallBack? = null

    override fun startFlashing() {
        animationCallBack?.startFlashingAnimation()
    }

    override fun stopFlashing() {
        animationCallBack?.stopFlashingAnimation()
    }
}