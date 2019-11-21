package maume.com.meuprojeto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var intent = getIntent()
        var onePlayer = intent.getBooleanExtra("onePlayer", true)

        if(onePlayer){
            textViewPlayer2.isEnabled = false
            editTextNumPlayer2.isEnabled = false
        }
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun cliqueSorteio(view: View) {

        val textoResult = textoResultado
        var intent = getIntent()
        var onePlayer = intent.getBooleanExtra("onePlayer", true)

        if (onePlayer){
            if ( verificaCamposVazios(editTextNumPlayer1.text))
                textoResult.setText("Preencha todos os campos")
        }

        if(verificaCamposVazios(editTextNumPlayer1.text, editTextNumPlayer2.text))
            textoResult.setText("Preencha todos os campos")
        else {
            val numeroSelecionadoPlayer01 = editTextNumPlayer1.text.toString().toInt()
            val numeroSelecionadoPlayer02 = editTextNumPlayer2.text.toString().toInt()

            when (val numeroSorteado = Random.nextInt(0,6)){
                numeroSelecionadoPlayer01 -> textoResult.setText("O resultado foi: ${numeroSorteado}\nO jogador 01 foi o vencedor!!!")
                numeroSelecionadoPlayer02 -> textoResult.setText("O resultado foi: ${numeroSorteado}\nO jogador 02 foi o vencedor!!!")
                else -> textoResult.setText("O resultado foi: ${numeroSorteado}\nNinguém Acertou!!!")
            }
        }
    }

    fun verificaCamposVazios(numero01: Editable) : Boolean {
        return numero01.isEmpty()
    }

    fun verificaCamposVazios(numero01: Editable, numero02: Editable) : Boolean{
        return numero01.isEmpty() || numero02.isEmpty()
    }
}
