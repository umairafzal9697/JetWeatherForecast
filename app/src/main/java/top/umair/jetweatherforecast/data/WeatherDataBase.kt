package top.umair.jetweatherforecast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import top.umair.jetweatherforecast.model.Favorite

@Database(entities = [Favorite::class], version = 1, exportSchema = false)
abstract class WeatherDataBase:RoomDatabase() {
    abstract fun weatherDao():WeatherDao
}