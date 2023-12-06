package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.aula5.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var resultado = 0
    private var score = 0
    private lateinit var txtResultado: TextView
    private lateinit var btnNovo: Button
    private lateinit var txtNumerosSorteados: TextView
    private val numerosSorteados = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById(R.id.txtResultado)
        btnNovo = findViewById(R.id.btnNovo)
        txtNumerosSorteados = findViewById(R.id.txtNumerosSorteados)

        novoJogo()
    }

    private fun novoJogo(){
        txtResultado.text = "Par ou Impar?"
        resultado = Random.nextInt(0, 10)
        btnNovo.visibility = View.INVISIBLE
    }

    fun novoJogo(view: View){
        novoJogo()
    }

    fun jogada(view: View){
        if(resultado % 2 == view.tag.toString().toInt()) {
            if(btnNovo.visibility == View.INVISIBLE) {
                score++
            }
        }

        numerosSorteados.add(resultado)
        exibirNumerosSorteados()

        title = "Score: $score"
        txtResultado.text = "$resultado"

        btnNovo.visibility = View.VISIBLE
    }

    private fun exibirNumerosSorteados() {
        val numerosFormatados = numerosSorteados.joinToString("- ")
        txtNumerosSorteados.text = "NÃºmeros sorteados: $numerosFormatados"
    }
}
