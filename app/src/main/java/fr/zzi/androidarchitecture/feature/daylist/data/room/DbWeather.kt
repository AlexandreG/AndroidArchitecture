package fr.zzi.androidarchitecture.feature.daylist.data.room

import androidx.room.ColumnInfo
import fr.zzi.androidarchitecture.feature.daylist.domain.Weather

data class DbWeather(
    @ColumnInfo(name = Columns.ICON) val icon: String,
    @ColumnInfo(name = Columns.TITLE) val main: String,
    @ColumnInfo(name = Columns.DESCRIPTION) val description: String
) {

    object Columns {
        const val ICON = "ICON"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
    }

    fun convert(): Weather {
        return Weather(icon, main, description)
    }
}