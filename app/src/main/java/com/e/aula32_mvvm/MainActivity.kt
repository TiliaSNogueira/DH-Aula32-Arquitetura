package com.e.aula32_mvvm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.LiveData

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                //passa a var soma do viewmodel
                myApp(viewModel.soma)
            }
        }

    }

    //layout composto que vai dentro do Material Theme

    //passa o viewmodel para dentro do myApp
    @Composable
    fun myApp(somaData: LiveData<Int>) {

        //pega a var soma de dentro do MainViewModel
        val soma by somaData.observeAsState()



        //andaime
        Scaffold(
            topBar = {

            },



            bodyContent = {
                //para dizer que o viewModel está escutando esse texto:
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,


                ) {
                    Text(soma.toString())
                }


            },


            floatingActionButton = {
                FloatingActionButton(onClick = {
                    viewModel.incremento(1)
                    Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
                }) {
                    //não pega pelo R.id, pega o icone pelo nome dele a galeria de vector asset
                    Icon(Icons.Filled.Add)
                }
            },
        )
    }


}