package com.marton.tamas.curveappchallange.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.VISIBLE
import com.marton.tamas.curveappchallange.R
import com.marton.tamas.curveappchallange.common.*
import com.marton.tamas.curveappchallange.databinding.ActivitySummarizeBinding
import com.marton.tamas.curveappchallange.flash.FlashingHandler
import com.marton.tamas.curveappchallange.model.Sum
import com.marton.tamas.curveappchallange.viewmodel.SummarizeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SummarizeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivitySummarizeBinding
    private lateinit var summarizeViewModel: SummarizeViewModel
    private val flashingHandler = FlashingHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_summarize)

        summarizeViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(SummarizeViewModel::class.java)
        binding.vm = summarizeViewModel


        summarizeViewModel.sumValue.observe(this, Observer<Sum> { number -> binding.sumObject = number })

        summarizeViewModel.prepareToFlashing.observe(this, Observer<Boolean> {
            when (intent.getIntExtra(FLASHING_MODE, 0)) {
                HANDLER -> flashingWithHandler()
                TIMER -> flashingWithTimer()
                RXJAVA -> flashingWithRxJava()
            }
        })

        flashingHandler.doFlashing.observe(this, Observer<Boolean> { runOnUiThread { binding.sum.visibility = if (binding.sum.visibility == VISIBLE) View.INVISIBLE else VISIBLE } })
    }

    private fun flashingWithHandler() {
        flashingHandler.startFlashing()
    }

    private fun flashingWithTimer() {
        flashingHandler.startFlashing()
    }

    private fun flashingWithRxJava() {
        flashingHandler.startFlashing()
    }
}