package digitalhouse.desafio.desafiofirebase.ui


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import digitalhouse.desafio.desafiofirebase.databinding.ActivityRegisterGameBinding
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_register_game.*

class RegisterGame : AppCompatActivity() {

    lateinit var binding: ActivityRegisterGameBinding

    lateinit var alertDialog: AlertDialog
    lateinit var storageReference: StorageReference
    private val CODE_IMG = 1000

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.imgFoto.setOnClickListener {
            loadimg()
        }

    }

    private fun loadimg() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Image Capture"), CODE_IMG)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        alertDialog = SpotsDialog.Builder().setContext(this).build()
        storageReference = FirebaseStorage.getInstance().getReference("prod_img")
        if (requestCode == CODE_IMG) {
            alertDialog.show()
            val uploadTask = storageReference.putFile(data!!.data!!)
            uploadTask.continueWithTask { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Chegando!", Toast.LENGTH_SHORT).show()
                }
                storageReference!!.downloadUrl
            }.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    val url = downloadUri!!.toString()
                            .substring(0, downloadUri.toString().indexOf("&token"))
                    Log.i("Link Direto ", url)
                    alertDialog.dismiss()
                    Picasso.get().load(url).into(img_load_game)
                }
            }
        }

    }
}