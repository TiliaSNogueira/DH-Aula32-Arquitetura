package com.e.aula32_mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    //criou variavel MutableLiveData que inicia em 0
    val soma = MutableLiveData<Int>().apply {
        value = 0
    }

    //método de incremento
    fun incremento(num: Int) {

        soma.value.let {
            soma.value = it!! + num
        }
    }

    //método refresh que sera o contador
    fun refresh(){
        soma.value = 0
    }


}