package com.geektech.contermvp.view

import com.geektech.contermvp.model.CounterModel
import com.geektech.contermvp.presenter.Presenter

class Injector {

    companion object{
        fun getPresenter():Presenter{
            return Presenter()
        }
        fun getModel(): CounterModel {
            return CounterModel()
        }
    }
}