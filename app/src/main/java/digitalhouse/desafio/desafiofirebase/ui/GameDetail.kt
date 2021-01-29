package digitalhouse.desafio.desafiofirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import digitalhouse.desafio.desafiofirebase.databinding.ActivityGameDetailBinding

class GameDetail : AppCompatActivity() {

    private lateinit var binding: ActivityGameDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val game = intent.getSerializableExtra("game")
        val year = intent.getSerializableExtra("year")
        val desc = intent.getSerializableExtra("desc")
        val url = intent.getSerializableExtra("url")

        binding.txtNameGameDetail1.text = game.toString()
        binding.inGameDetail.txtNameGameDetail.text = game.toString()
        binding.inGameDetail.txtYearGameDetail.text = year.toString()
        binding.inGameDetail.txtDescGameDetail.text = desc.toString()

        Picasso.get().load(url.toString())
                .into(binding.imgGameDetail)
    }
}