package maume.com.meuprojeto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    fun cliqueSorteio(view: View){
        val numeroSelecionadoPlayer01 = findViewById<TextView>(R.id.editTextNumPlayer1).text.toString()
        val numeroSelecionadoPlayer02 = findViewById<TextView>(R.id.editTextNumPlayer2).text.toString()

        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        val numeroSorteado = List(1) { Random.nextInt(0,5)}

        if (numeroSorteado[0].toString() == numeroSelecionadoPlayer01){
            textoResultado.setText("O resultado foi: ${numeroSorteado[0]}\n O jogador 01 foi o vencedor!!!")
        }
        else if (numeroSorteado[0].toString() == numeroSelecionadoPlayer02){
            textoResultado.setText("O resultado foi: ${numeroSorteado[0]}\n O jogador 02 foi o vencedor!!!")
        }
        else{
            textoResultado.setText("O resultado foi: ${numeroSorteado[0]}\n Ninguém Acertou!!!")
        }

        Log.i("BOTÃO","Botão Pressionado!")
    }
}
