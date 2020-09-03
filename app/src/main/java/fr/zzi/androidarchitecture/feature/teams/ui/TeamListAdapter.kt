package fr.zzi.androidarchitecture.feature.teams.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.teams.domain.Team

class TeamListAdapter(private val context: Context) :
    RecyclerView.Adapter<TeamListAdapter.TeamViewHolder>() {

    interface Listener {
        fun onItemClick(teamName: String)
    }

    var data: List<Team> = emptyList()
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_team_item, parent, false)
        return TeamViewHolder(item)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        data.get(position).run {
            Glide.with(context).load(this.strTeamBadge).into(holder.teamImage)

            holder.itemView.setOnClickListener {
                listener?.onItemClick(this.strTeam)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val teamImage: ImageView = view.findViewById(R.id.team_item_image)
    }
}