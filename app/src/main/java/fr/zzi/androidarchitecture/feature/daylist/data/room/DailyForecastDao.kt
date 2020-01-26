package fr.zzi.androidarchitecture.feature.daylist.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class DailyForecastDao {

    fun insertAll(dailyForecastList: List<DbDailyForecast>) {
        deleteAll()
        dailyForecastList.forEach { insert(it) }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insert(dailyForecast: DbDailyForecast): Long

    @Query("SELECT * FROM ${DbDailyForecast.TABLE_NAME}")
    abstract fun getAll(): List<DbDailyForecast>

    @Query("DELETE FROM ${DbDailyForecast.TABLE_NAME}")
    abstract fun deleteAll()

}