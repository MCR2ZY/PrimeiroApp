package maume.com.meuprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        buttonOnePlayer.setOnClickListener {
            var i = Intent(this, GameActivity::class.java)
            i.putExtra("onePlayer", true)
            startActivity(i)
        }

        buttonTwoPlayers.setOnClickListener {
            var i = Intent(this, GameActivity::class.java)
            startActivity(i)
        }
    }
}
