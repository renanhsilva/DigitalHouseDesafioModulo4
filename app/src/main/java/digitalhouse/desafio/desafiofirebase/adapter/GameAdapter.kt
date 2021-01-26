package digitalhouse.desafio.desafiofirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.model.Game

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var img_game : ImageView = itemView.findViewById(R.id.img_game)
        var txt_titleGame : TextView = itemView.findViewById(R.id.txt_titleGame)
        var txt_yearGame : TextView = itemView.findViewById(R.id.txt_yearGame)
    }

    private val differCallback = object : DiffUtil.ItemCallback<Game>(){
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return  oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val games = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(games.url).into(holder.img_game)
            holder.txt_titleGame.text = games.name
            holder.txt_yearGame.text = games.year
        }
    }

}