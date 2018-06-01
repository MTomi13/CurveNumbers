package com.marton.tamas.curveappchallange.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import android.widget.EditText
import com.annimon.stream.Stream
import com.marton.tamas.curveappchallange.model.Sum
import java.util.*
import javax.inject.Inject


class SummarizeViewModel
@Inject constructor() : ViewModel() {

    val numbers = HashMap<String, Int>()
    private lateinit var newNumber: String

    var prepareToFlashing: MutableLiveData<Boolean> = MutableLiveData()
    var sumValue: MutableLiveData<Sum> = MutableLiveData()

    fun textChanged(text: CharSequence) {
        newNumber = text.toString()
    }

    fun editTextChanged(identifier: String) {
        val num = newNumber
        numbers[identifier] = if (num.isNotEmpty()) {
            Integer.parseInt(num)
        } else {
            0
        }
        sumValue.value = calculateSum()
    }

    fun onClick(view: View) {
        (view as EditText).text.clear()
    }

    fun onPrepareToFlashing() {
        prepareToFlashing.value = true
    }

    private fun calculateSum(): Sum = Sum(Stream.of(numbers).mapToInt({ it.value }).sum())
}