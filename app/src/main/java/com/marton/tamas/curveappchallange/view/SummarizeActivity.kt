package com.marton.tamas.curveappchallange.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import com.marton.tamas.curveappchallange.R
import com.marton.tamas.curveappchallange.common.*
import com.marton.tamas.curveappchallange.databinding.ActivitySummarizeBinding
import com.marton.tamas.curveappchallange.flash.animation.AnimationCallBack
import com.marton.tamas.curveappchallange.flash.animation.FlashingAnimation
import com.marton.tamas.curveappchallange.flash.handler.FlashingHandler
import com.marton.tamas.curveappchallange.flash.rx.FlashingRxInterval
import com.marton.tamas.curveappchallange.flash.rx.FlashingRxSchedulers
import com.marton.tamas.curveappchallange.flash.timer.FlashingTimer
import com.marton.tamas.curveappchallange.model.Sum
import com.marton.tamas.curveappchallange.viewmodel.SummarizeViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class SummarizeActivity : AppCompatActivity(), AnimationCallBack {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivitySummarizeBinding

    private lateinit var summarizeViewModel: SummarizeViewModel
    private var doFlashing: MutableLiveData<Boolean> = MutableLiveData()

    private val flashingHandler = FlashingHandler(doFlashing)
    private val flashingRxInterval = FlashingRxInterval(doFlashing)
    private val flashingRxSchedulers = FlashingRxSchedulers(doFlashing)
    private val flashingTimer = FlashingTimer(doFlashing)
    private val flashingAnimation = FlashingAnimation(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setupBinding()

        val flashMode = intent.getIntExtra(FLASHING_MODE, 0)

        setupToolbar(intent.getStringExtra(FLASHING_MODE_TITLE))

        summarizeViewModel.sumValue.observe(this, Observer<Sum> { number -> binding.sumObject = number })

        summarizeViewModel.prepareToFlashing.observe(this, Observer<Boolean> { isFlashing ->
            if (isFlashing!!) {
                startFlashingByMode(flashMode)
            } else {
                binding.sum.visibility = VISIBLE
                stopFlashingByMode(flashMode)
            }
        })

        doFlashing.observe(this, Observer<Boolean> {
            flashing()
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            supportFinishAfterTransition()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_summarize)
        summarizeViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(SummarizeViewModel::class.java)
        binding.vm = summarizeViewModel
    }

    private fun setupToolbar(title: String?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        toolbar.title = title
    }

    private fun flashing() {
        binding.sum.visibility = if (binding.sum.visibility == VISIBLE) View.INVISIBLE else VISIBLE
    }

    private fun startFlashingByMode(flashMode: Int) {
        when (flashMode) {
            HANDLER -> flashingHandler.startFlashing()
            TIMER -> flashingTimer.startFlashing()
            RXJAVA -> flashingRxInterval.startFlashing()
            RXJAVA_SCHEDULER -> flashingRxSchedulers.startFlashing()
            ANIMATION -> flashingAnimation.startFlashing()
        }
    }

    private fun stopFlashingByMode(flashMode: Int) {
        when (flashMode) {
            HANDLER -> flashingHandler.stopFlashing()
            TIMER -> flashingTimer.stopFlashing()
            RXJAVA -> flashingRxInterval.stopFlashing()
            RXJAVA_SCHEDULER -> flashingRxSchedulers.stopFlashing()
            ANIMATION -> flashingAnimation.stopFlashing()
        }
    }

    override fun startFlashingAnimation() {
        binding.sum.startAnimation(AnimationUtils.loadAnimation(this, R.anim.flashing))
    }

    override fun stopFlashingAnimation() {
        binding.sum.clearAnimation()
    }
}