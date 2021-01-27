package digitalhouse.desafio.desafiofirebase.ui


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.adapter.GameAdapter
import digitalhouse.desafio.desafiofirebase.databinding.ActivityHomeBinding
import digitalhouse.desafio.desafiofirebase.databinding.ActivityLoginBinding
import digitalhouse.desafio.desafiofirebase.model.GameViewModel
import kotlinx.android.synthetic.main.activity_home.*


class Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    private val viewModel by viewModels<GameViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return GameViewModel() as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        recyclerViewConfig()
        binding.btAddGame.setOnClickListener(openActivity(RegisterGame::class.java))

    }

    private fun recyclerViewConfig(){
        viewModel.getData()
        val recyclerView = binding.rvGames
        viewModel.gamelist.observe(this){
            recyclerView.adapter = GameAdapter(it, this)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onStart() {
        super.onStart()
    }

    fun openActivity(activity: Class<out Activity>): View.OnClickListener? {
        return View.OnClickListener {
            startActivity(Intent(this, activity))
        }
    }

}