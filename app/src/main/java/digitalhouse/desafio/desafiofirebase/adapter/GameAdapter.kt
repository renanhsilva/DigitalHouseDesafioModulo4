package digitalhouse.desafio.desafiofirebase.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import digitalhouse.desafio.desafiofirebase.R
import digitalhouse.desafio.desafiofirebase.model.Game
import kotlinx.android.synthetic.main.item_games.view.*

    class GameAdapter(val listGame: ArrayList<Game>, val context: Context): RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
            return GameViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
            val currentItem = listGame[position]
            holder.name.text = currentItem.name
            holder.year.text = currentItem.year
            Picasso.get().load(currentItem.url)
                    .into(holder.url)
        }

        override fun getItemCount(): Int {
            return listGame.size
        }

        class GameViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
            var name: TextView = itemView.findViewById(R.id.txt_titleGame)
            var year: TextView = itemView.findViewById(R.id.txt_yearGame)
            var url: ImageView = itemView.findViewById(R.id.img_game)
        }
}