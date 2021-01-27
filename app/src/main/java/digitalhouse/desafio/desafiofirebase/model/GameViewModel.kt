package digitalhouse.desafio.desafiofirebase.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import digitalhouse.desafio.desafiofirebase.entities.Game
import digitalhouse.desafio.desafiofirebase.service.cr

class GameViewModel() : ViewModel() {

    var gamelist = MutableLiveData<ArrayList<Game>>()

    fun getData() {
        var listaextrac = ArrayList<Game>()
        cr.get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        listaextrac.add(Game(document.data["name"].toString(), document.data["year"].toString(), document.data["desc"].toString(), document.data["url"].toString()))
                    }
                    gamelist.value = listaextrac
                    Log.i("TAG","RESPONSE FIREBASE " + gamelist.value.toString())
                } else {
                    Log.e("TAG", "ERROR", task.exception)
                }
            }
    }
}