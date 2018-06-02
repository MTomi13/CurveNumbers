package com.marton.tamas.curveappchallange.di

import com.marton.tamas.curveappchallange.CurveAppChallengeApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class), (ActivityBuilder::class), (FlashingImplModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun flashingImplModule(flashingImplModule: FlashingImplModule): Builder

        fun build(): AppComponent
    }

    fun inject(app: CurveAppChallengeApplication)
}