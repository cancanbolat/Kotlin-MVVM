package com.example.kotlin_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.kotlin_mvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewModel define
        viewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        //click buttons
        btn_increase.setOnClickListener { increaseValue() }
        btn_decrease.setOnClickListener { decreaseValue() }
        btn_reset.setOnClickListener { resetValue() }


        // counter text
        counter_text.text = viewModel.counterValue.toString()

    }


    // increase click
    private fun increaseValue() {
        viewModel.counterValue+=1
        counter_text.text = viewModel.counterValue.toString()
    }

    // decrease click
    private fun decreaseValue() {
        viewModel.counterValue-=1
        counter_text.text = viewModel.counterValue.toString()
    }

    // reset click
    private fun resetValue() {
        viewModel.counterValue = 0
        counter_text.text = viewModel.counterValue.toString()
    }


}