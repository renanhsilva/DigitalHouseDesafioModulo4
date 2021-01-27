package digitalhouse.desafio.desafiofirebase.model

import digitalhouse.desafio.desafiofirebase.R

data class Game (var name: String, var year: String, var desc: String, var url: String){

}

class GamesBuild {
    var nameGame: String = ""
    var yearGame: String = ""
    var descGame: String = ""
    var imgGame: String = ""

    fun build(): Game = Game(nameGame, yearGame, descGame, imgGame)
}

fun games(block: GamesBuild.() -> Unit): Game = GamesBuild().apply(block).build()

fun listGames(): MutableList<Game> = mutableListOf(
    games {
        nameGame = "Kratos"
        yearGame = "2008"
        descGame = "teste"
        imgGame = "test"
    }
)