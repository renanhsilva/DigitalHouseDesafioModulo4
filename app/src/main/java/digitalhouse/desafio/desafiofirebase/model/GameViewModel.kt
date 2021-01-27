package digitalhouse.desafio.desafiofirebase.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import digitalhouse.desafio.desafiofirebase.service.cr

class GameViewModel {

    var gameList = MutableLiveData<ArrayList<Game>>()

    fun getListaJogos() {
        var listaAux = ArrayList<Game>()
        cr.get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        listaAux.add(Game(document.data["name"].toString(), document.data["year"].toString(), document.data["desc"].toString(), document.data["url"].toString()))
                    }
                    gameList.value = listaAux
                } else {
                    Log.w("HomeViewModel", "Exceção ", task.exception)
                }
            }
    }
}