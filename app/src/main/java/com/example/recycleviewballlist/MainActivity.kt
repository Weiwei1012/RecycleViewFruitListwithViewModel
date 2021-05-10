package com.example.recycleviewballlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewballlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val ballList = ArrayList<Balls>()
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

//        initBallList()  //set up the data source
        val layoutManager = LinearLayoutManager(this)
        //val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.recycleView.layoutManager = layoutManager
        val adapter = BallAdapter()  //customized your own adapter
        //adapter.submitList(ballList)
        binding.recycleView.adapter = adapter
        //binding.recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        //binding.recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        viewModel.ballList.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

    }

//    private fun initBallList() {
//        repeat(6) {
//            ballList.add(Balls("Baseball",R.drawable.baseball))
//            ballList.add(Balls("Basketball",R.drawable.basketball))
//            ballList.add(Balls("Football",R.drawable.football))
//            ballList.add(Balls("Other",R.drawable.other))
//        }
//    }
}
