package fr.zzi.androidarchitecture.feature.daylist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.daylist.ui.DayListAdapter.DayItemViewHolder

class DayListAdapter(private val context: Context) : RecyclerView.Adapter<DayItemViewHolder>() {

    interface Listener {
        fun onItemClick(position: Int)
    }

    var data: List<DayItemData> = emptyList()
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayItemViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_day_item, parent, false)
        return DayItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: DayItemViewHolder, position: Int) {
        data.get(position).run {
            holder.date.text = date
            holder.title.text = title
            holder.description.text = description
            Glide.with(context).load(imageUrl).into(holder.image)
        }

        holder.itemView.setOnClickListener {
            listener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DayItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.day_item_date)
        val image: ImageView = view.findViewById(R.id.day_item_image)
        val title: TextView = view.findViewById(R.id.day_item_title)
        val description: TextView = view.findViewById(R.id.day_item_description)

    }
}