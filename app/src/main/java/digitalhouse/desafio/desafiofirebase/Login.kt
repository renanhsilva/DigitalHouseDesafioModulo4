package digitalhouse.desafio.desafiofirebase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.bt_login).setOnClickListener(openActivity(Home::class.java))
        findViewById<TextView>(R.id.txt_register).setOnClickListener(openActivity(Register::class.java))
    }

    fun openActivity(activity: Class<out Activity>): View.OnClickListener? {
        return View.OnClickListener {
            startActivity(Intent(this, activity))
        }
    }
}