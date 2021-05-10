package com.example.recycleviewballlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    val ballList = MutableLiveData<List<Balls>>()

    init {
        val ballListSource = ArrayList<Balls>() //temporary array
        repeat(6) {
            with(ballListSource) {
                add(Balls("Baseball", R.drawable.baseball))
                add(Balls("Basketball", R.drawable.basketball))
                add(Balls("Football", R.drawable.football))
                add(Balls("Other", R.drawable.other))
            }
        }
        ballList.value = ballListSource
    }


}