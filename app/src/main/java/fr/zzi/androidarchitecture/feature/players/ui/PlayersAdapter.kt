package fr.zzi.androidarchitecture.feature.players.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.players.domain.Player

class PlayersAdapter(private val context: Context) :
    RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>() {

    var data: List<Player> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_player_item, parent, false)
        return PlayerViewHolder(item)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        data.get(position).run {
            Glide.with(context).load(strThumb).into(holder.photo)
            holder.name.text = strPlayer
            holder.position.text = strPosition
            holder.birthDate.text = "birth date : $dateBorn"
            holder.price.text = if (strSinging.isNullOrEmpty()) {
                "price : /"
            } else {
                "price : $strSinging"
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.player_item_image)
        val name: TextView = view.findViewById(R.id.player_item_name)
        val position: TextView = view.findViewById(R.id.player_item_position)
        val birthDate: TextView = view.findViewById(R.id.player_item_birth_date)
        val price: TextView = view.findViewById(R.id.player_item_price)
    }
}