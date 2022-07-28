package com.geektech.contermvp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.contermvp.databinding.ActivityMainBinding
import com.geektech.contermvp.presenter.Presenter
import com.geektech.contermvp.view.CounterView
import com.geektech.contermvp.view.Injector
import com.geektech.contermvp.view.showToast

class MainActivity : AppCompatActivity(), CounterView {


    lateinit var binding: ActivityMainBinding
     var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter=Injector.getPresenter()
        presenter.attachView(this)
        initClicker()
    }


    private fun initClicker() {
        with(binding) {
            incrementBtn.setOnClickListener {
                presenter.increment()
            }

            decrementBtn.setOnClickListener {
                presenter.decrement()
            }
        }
    }

    override fun updateCount(count: String) {
        binding.counterTv.text = count
    }

    override fun showToastPlus() {
        showToast("Поздравляю")
    }

    override fun showGreenPlus() {
        binding.counterTv.setTextColor(Color.GREEN)
    }

}