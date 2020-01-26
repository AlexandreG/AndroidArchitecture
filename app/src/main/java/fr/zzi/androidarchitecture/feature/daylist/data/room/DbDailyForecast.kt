package fr.zzi.androidarchitecture.feature.daylist.data.room

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.zzi.androidarchitecture.feature.daylist.domain.DailyForecast

@Entity(tableName = DbDailyForecast.TABLE_NAME)
data class DbDailyForecast(
    @ColumnInfo(name = Columns.TEMPERATURE) var dt: Long,
    @Embedded val weather: DbWeather
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.ID)
    var id: Long = 0

    companion object {
        const val TABLE_NAME = "DbDailyForecast"

        fun convert(forecast: DailyForecast): DbDailyForecast {
            return DbDailyForecast(
                forecast.dt,
                DbWeather(
                    forecast.weather.first().icon,
                    forecast.weather.first().main,
                    forecast.weather.first().description
                )
            )
        }
    }

    object Columns {
        const val TEMPERATURE = "TEMPERATURE"
        const val ID = "ID"
    }

    fun convert(): DailyForecast {
        return DailyForecast(
            listOf(weather.convert()),
            dt
        )
    }

}