package digitalhouse.desafio.desafiofirebase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.databinding.ActivityLoginBinding
import digitalhouse.desafio.desafiofirebase.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        binding.inRegister.btCreateAccount.setOnClickListener(createAccount())

    }

    fun createAccount(): View.OnClickListener? {
        return View.OnClickListener {
            val name = binding.inRegister.txtName.text.toString()
            val email = binding.inRegister.txtEmailRegister.text.toString()
            val senha = binding.inRegister.txtPasswordRegister.text.toString()
            val senharepeat = binding.inRegister.txtPasswordRepeatRegister.text.toString()

            if (senha == senharepeat){
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d("create account", "createUserWithEmail:success")
                        } else {
                            Log.w("create account", "createUserWithEmail:failure", task.exception)
                        }
                    }

            } else {
                Toast.makeText(this, "Senhas não conferem", Toast.LENGTH_SHORT).show()
            }

        }
    }
}