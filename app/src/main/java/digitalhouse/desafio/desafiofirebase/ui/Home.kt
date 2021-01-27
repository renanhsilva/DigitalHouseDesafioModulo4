package digitalhouse.desafio.desafiofirebase.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.adapter.GameAdapter
import digitalhouse.desafio.desafiofirebase.model.Game
import digitalhouse.desafio.desafiofirebase.model.listGames
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        rv_games.adapter = GameAdapter(listGames() as ArrayList<Game>,this)
        rv_games.layoutManager = LinearLayoutManager(this)
    }
}