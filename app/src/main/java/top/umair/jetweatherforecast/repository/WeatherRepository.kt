package top.umair.jetweatherforecast.repository

import android.util.Log
import top.umair.jetweatherforecast.data.DataOrException
import top.umair.jetweatherforecast.model.Weather
import top.umair.jetweatherforecast.model.WeatherObject
import top.umair.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(cityQuery: String)
            : DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery)

        }catch (e: Exception){
            Log.d("REX", "getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")
        return  DataOrException(data = response)

    }

}