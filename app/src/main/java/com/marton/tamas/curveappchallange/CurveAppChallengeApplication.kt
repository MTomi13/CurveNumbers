package com.marton.tamas.curveappchallange

import android.app.Activity
import android.app.Application
import com.marton.tamas.curveappchallange.di.DaggerAppComponent
import com.marton.tamas.curveappchallange.di.FlashingImplModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class CurveAppChallengeApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .flashingImplModule(FlashingImplModule())
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}