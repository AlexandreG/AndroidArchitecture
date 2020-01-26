package fr.zzi.androidarchitecture.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.zzi.androidarchitecture.feature.daylist.data.room.DailyForecastDao
import fr.zzi.androidarchitecture.feature.daylist.data.room.DbDailyForecast

@Database(
    entities = [
        DbDailyForecast::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDailyForecastDao(): DailyForecastDao

    companion object {
        private lateinit var INSTANCE: AppDatabase

        fun init(context: Context) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "main-database"
            ).build()
        }

        fun getInstance(): AppDatabase {
            return INSTANCE
        }

    }

}