package com.marton.tamas.curveappchallange

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marton.tamas.curveappchallange.databinding.ActivitySummarizeBinding

class SummarizeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummarizeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_summarize)
    }
}
