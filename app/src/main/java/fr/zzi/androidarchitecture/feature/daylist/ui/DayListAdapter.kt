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
import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast
import fr.zzi.androidarchitecture.feature.daylist.ui.DayListAdapter.WeatherViewHolder
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DayListAdapter(private val context: Context) : RecyclerView.Adapter<WeatherViewHolder>() {
    private var data: List<DailyForecast> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_weather_item, parent, false)
        return WeatherViewHolder(item)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = data.get(position).weather[0]
        val timestamp = data.get(position).dt

        val date = Date(timestamp * 1000)
        val formatter: DateFormat = SimpleDateFormat("dd/MM")
        holder.date.text = formatter.format(date)
        holder.title.text = weather.main
        holder.description.text = weather.description
        Picasso.with(context).load(weather.iconURL).into(holder.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class WeatherViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        var date: TextView
        var image: ImageView
        var title: TextView
        var description: TextView

        init {
            date = view.findViewById<View>(R.id.item_weather_date) as TextView
            image =
                view.findViewById<View>(R.id.item_weather_image) as ImageView
            title = view.findViewById<View>(R.id.item_weather_title) as TextView
            description =
                view.findViewById<View>(R.id.item_weather_description) as TextView
        }
    }

    fun setData(dailyForecasts: List<DailyForecast>) {
        data = dailyForecasts
    }

}