package com.marton.tamas.curveappchallange

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marton.tamas.curveappchallange.base.ViewModelFactory
import com.marton.tamas.curveappchallange.databinding.ActivitySummarizeBinding
import com.marton.tamas.curveappchallange.viewmodel.SummarizeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SummarizeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var binding: ActivitySummarizeBinding
    private lateinit var summarizeViewModel: SummarizeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_summarize)

        summarizeViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(SummarizeViewModel::class.java)
    }
}
