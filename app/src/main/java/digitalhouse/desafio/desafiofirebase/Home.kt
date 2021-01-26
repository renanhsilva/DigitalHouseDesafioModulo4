package digitalhouse.desafio.desafiofirebase


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import digitalhouse.desafio.desafiofirebase.adapter.GameAdapter


class Home : AppCompatActivity() {

    lateinit var gameAdapter: GameAdapter
    lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        gameAdapter = GameAdapter()
        gridLayoutManager = GridLayoutManager(this,2)
        rv_games.adapter = gameAdapter
        rv_games.layoutManager = GridLayoutManager(this, 2)
        rv_games.hasFixedSize()
    }
}