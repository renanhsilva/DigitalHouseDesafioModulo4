package digitalhouse.desafio.desafiofirebase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import digitalhouse.desafio.desafiofirebase.databinding.ActivityRegisterBinding
import digitalhouse.desafio.desafiofirebase.databinding.ActivityRegisterGameBinding

class RegisterGame : AppCompatActivity() {

    lateinit var binding: ActivityRegisterGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}