package com.paolomanlunas.forecaster.data.network

import androidx.lifecycle.LiveData
import com.paolomanlunas.forecaster.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
   val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

   suspend fun fetchCurrentWeather(
      location: String
   )
}