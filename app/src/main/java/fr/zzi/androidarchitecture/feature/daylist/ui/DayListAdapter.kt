package fr.zzi.androidarchitecture.feature.daylist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.zzi.androidarchitecture.R
import fr.zzi.androidarchitecture.feature.daylist.ui.DayListAdapter.DayItemViewHolder

class DayListAdapter(private val context: Context) : RecyclerView.Adapter<DayItemViewHolder>() {
    private var data: List<DayItemData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayItemViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_weather_item, parent, false)
        return DayItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: DayItemViewHolder, position: Int) {
        val currentItem = data.get(position)

        holder.date.text = currentItem.date
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        Picasso.with(context).load(currentItem.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class DayItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView
        val image: ImageView
        val title: TextView
        val description: TextView

        init {
            date = view.findViewById(R.id.item_weather_date)
            image = view.findViewById(R.id.item_weather_image)
            title = view.findViewById(R.id.item_weather_title)
            description = view.findViewById(R.id.item_weather_description)
        }
    }

    fun setData(dataList: List<DayItemData>) {
        data = dataList
    }

}