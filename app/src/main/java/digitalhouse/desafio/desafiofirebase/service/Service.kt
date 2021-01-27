package digitalhouse.desafio.desafiofirebase.service

import com.google.firebase.firestore.FirebaseFirestore

var db = FirebaseFirestore.getInstance()
var cr = db.collection("Game")