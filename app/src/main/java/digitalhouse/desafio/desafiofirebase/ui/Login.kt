package digitalhouse.desafio.desafiofirebase.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.databinding.ActivityLoginBinding



class Login : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        binding.inLogin.btLogin.setOnClickListener(login())
        binding.inLogin.txtRegister.setOnClickListener(openActivity(Register::class.java))


    }

    fun openActivity(activity: Class<out Activity>): View.OnClickListener? {
        return View.OnClickListener {
            startActivity(Intent(this, activity))
        }
    }

    fun login(): View.OnClickListener? {
        return View.OnClickListener {
            val email = binding.inLogin.txtEmail.toString()
            val senha = binding.inLogin.txtPassword.toString()

            if (!email.trim().equals("") && !senha.trim().equals("")) {

                auth(email, senha)
                Log.i("TAG", "senha $senha")
                Log.i("TAG", "email $email")
            } else {
                Toast.makeText(this, "Preencha corretamente os dados", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun auth(email: String, senha: String) {
        auth.signInWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Login com Sucesso", Toast.LENGTH_SHORT).show()
                    openActivity(Home::class.java)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Login com falha", Toast.LENGTH_SHORT).show()
                    var intent = Intent(application, Home::class.java)
                    startActivity(intent)
                }
            }
    }
}