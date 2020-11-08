package com.example.braintrainer

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList

class GameViewModel : ViewModel() {

    private val  TIMER :Int =30
    //private members to do calculations
    private var _timer: MutableLiveData<String> = MutableLiveData()
    private var _nav: MutableLiveData<Boolean> = MutableLiveData()
    private var _answerList: MutableLiveData<ArrayList<String>> = MutableLiveData()
    private var _express: MutableLiveData<String> = MutableLiveData()
    private var _corr_total: MutableLiveData<String>
    private var _displayText: MutableLiveData<String>

    //public member to be observed
    var answerList: MutableLiveData<ArrayList<String>>
    var corr_total: MutableLiveData<String>
    var express: MutableLiveData<String>
    var timer: MutableLiveData<String>
    var nav: MutableLiveData<Boolean>
    var displayText: MutableLiveData<String>


    private var answerLocation: Int = -1
    private var total: Int = 0
    private var corr: Int = 0

    init {
        //private members
        _express = MutableLiveData()
        _corr_total = MutableLiveData()
        _displayText = MutableLiveData()

        //public members
        corr_total = MutableLiveData()
        express = MutableLiveData()
        timer = MutableLiveData()
        nav = MutableLiveData()
        answerList = MutableLiveData()
        displayText = MutableLiveData()

        //default values
        _express.value=""
        express.value= _express.value
        _timer.value=TIMER.toString()
        timer.value=_timer.value
        displayText.value = ""
        _displayText.value = ""
        _corr_total.value = "0/0"
        corr_total.value=_corr_total.value
        _answerList.value= arrayListOf("0","0","0","0")
        answerList.value=_answerList.value


        object : CountDownTimer(TIMER.times(1000L), 1000) {
            override fun onFinish() {
                _nav.value = true
                nav.value = true
            }

            override fun onTick(millisUntilFinished: Long) {
                _timer.value = (millisUntilFinished / 1000).toString()
                timer.value = _timer.value
            }

        }.start()

        Question()
    }

    fun ansSelect(tag: String) {
        if (tag == answerLocation.toString()) {
            corr++
            _displayText.value = "Correct :)"
        } else _displayText.value = "Wrong :("
        total++
        _corr_total.value = "$corr/$total"
        corr_total.value = _corr_total.value
        displayText.value = _displayText.value
        Question()
    }

    private fun Question() {
        val rand = Random()
        val a = rand.nextInt(41)
        val b = rand.nextInt(41)
        _express.value = "$a+$b"
        express.value = _express.value
        answerLocation = rand.nextInt(4)
        _answerList.value = ArrayList()
        val corrAnswer = a + b
        for (i in 0..3) {
            if (i == answerLocation) _answerList.value?.add("${a+b}") else {
                var wAnswer = rand.nextInt(82)
                while (wAnswer == corrAnswer) wAnswer = rand.nextInt(82)
                _answerList.value?.add("$wAnswer")
            }
        }
        answerList.value = _answerList.value
    }

}