package com.e.aula32_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //criou, falou otipo e que vai usar o viewModels()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_toolbar)

        //quando clicar no refresh, o contador tem que zerar
        main_toolbar.setNavigationOnClickListener {
            //pega a função refresh que está dentro da viewModel
            viewModel.refresh()
            Toast.makeText(this, "Contador reiniciado", Toast.LENGTH_SHORT).show()
        }


        //viewModel paga a sua soma e, nesse lugar this, observa tal coisa
        viewModel.soma.observe(this, Observer {
            tvRes.text = it.toString()
        })



        fbIncrement.setOnClickListener {
            //pega a função incremento que está dentro da viewMoldel
            viewModel.incremento(1)
        }
    }
}