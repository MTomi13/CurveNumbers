package com.marton.tamas.curveappchallange.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.marton.tamas.curveappchallange.base.ViewModelFactory
import com.marton.tamas.curveappchallange.viewmodel.SummarizeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
abstract class SummarizeActivityModule {

    @Singleton
    @Binds
    abstract fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SummarizeViewModel::class)
    abstract fun provideSummarizeViewModel(summeViewModel: SummarizeViewModel): ViewModel
}