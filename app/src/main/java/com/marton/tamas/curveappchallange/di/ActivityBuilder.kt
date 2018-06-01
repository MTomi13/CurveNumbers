package com.marton.tamas.curveappchallange.di

import com.marton.tamas.curveappchallange.view.SummarizeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SummarizeActivityModule::class)])
    abstract fun bindSummarizeActivity(): SummarizeActivity
}