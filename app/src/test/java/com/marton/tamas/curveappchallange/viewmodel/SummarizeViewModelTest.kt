package com.marton.tamas.curveappchallange.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.marton.tamas.curveappchallange.model.Sum
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class SummarizeViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val viewmodel by lazy { SummarizeViewModel() }
    private val observer = mock(Observer::class.java) as Observer<Sum>
    private val prepareToFlashingObserver = mock(Observer::class.java) as Observer<Boolean>

    @Test
    fun calculateZeroWithEmptyValue() {
        viewmodel.sumValue.observeForever(observer)
        viewmodel.textChanged("")
        viewmodel.editTextChanged("01")

        verify<Observer<Sum>>(observer).onChanged(Sum(0))
    }

    @Test
    fun calculateWithOneValues() {
        viewmodel.sumValue.observeForever(observer)
        viewmodel.textChanged("1")
        viewmodel.editTextChanged("01")

        verify<Observer<Sum>>(observer).onChanged(Sum(1))
    }

    @Test
    fun calculateWithSameValues() {
        viewmodel.sumValue.observeForever(observer)
        viewmodel.textChanged("1")
        viewmodel.editTextChanged("01")
        viewmodel.textChanged("2")
        viewmodel.editTextChanged("01")

        verify<Observer<Sum>>(observer).onChanged(Sum(2))
    }

    @Test
    fun calculateWithSameAndThreeValues() {
        viewmodel.sumValue.observeForever(observer)
        viewmodel.textChanged("1")
        viewmodel.editTextChanged("01")
        viewmodel.textChanged("2")
        viewmodel.editTextChanged("01")
        viewmodel.textChanged("3")
        viewmodel.editTextChanged("01")
        viewmodel.textChanged("4")
        viewmodel.editTextChanged("21")
        viewmodel.textChanged("11")
        viewmodel.editTextChanged("20")
        viewmodel.textChanged("10")
        viewmodel.editTextChanged("11")

        verify<Observer<Sum>>(observer).onChanged(Sum(28))
    }

    @Test
    fun shouldPreparedToFlashing() {
        viewmodel.prepareToFlashing.observeForever(prepareToFlashingObserver)
        viewmodel.onPrepareToFlashing()

        verify<Observer<Boolean>>(prepareToFlashingObserver).onChanged(true)
    }
}