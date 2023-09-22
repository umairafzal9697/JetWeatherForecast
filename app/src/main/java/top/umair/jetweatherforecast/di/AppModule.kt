package top.umair.jetweatherforecast.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import top.umair.jetweatherforecast.data.WeatherDao
import top.umair.jetweatherforecast.data.WeatherDataBase
import top.umair.jetweatherforecast.network.WeatherApi
import top.umair.jetweatherforecast.utils.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDataBase: WeatherDataBase): WeatherDao =
        weatherDataBase.weatherDao()


    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDataBase
    = Room.databaseBuilder(
        context,
        WeatherDataBase::class.java,
        "weahter_database"
    )
        .fallbackToDestructiveMigration()
        .build()


    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }


}