package top.umair.jetweatherforecast.network

import retrofit2.http.GET
import retrofit2.http.Query
import top.umair.jetweatherforecast.model.Weather
import top.umair.jetweatherforecast.model.WeatherObject
import top.umair.jetweatherforecast.utils.Constants.API_KEY
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "imperial",
        @Query("appid") appid: String = API_KEY // your api key
    ): Weather

}