package top.umair.jetweatherforecast.screens.main

import android.provider.ContactsContract.Data
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import top.umair.jetweatherforecast.data.DataOrException
import top.umair.jetweatherforecast.model.City
import top.umair.jetweatherforecast.model.Weather
import top.umair.jetweatherforecast.model.WeatherObject
import top.umair.jetweatherforecast.repository.WeatherRepository
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    : ViewModel(){

    suspend fun getWeatherData(city: String)
            : DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city)

    }


}