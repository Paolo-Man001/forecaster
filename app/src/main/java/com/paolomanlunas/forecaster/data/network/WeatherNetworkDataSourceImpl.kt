package com.paolomanlunas.forecaster.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.paolomanlunas.forecaster.data.network.response.CurrentWeatherResponse
import com.paolomanlunas.forecaster.internal.NoConnectivityException

class WeatherNetworkDataSourceImpl (
   private val weatherApiService: WeatherApiService
): WeatherNetworkDataSource {
   private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
   override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
      get() = _downloadedCurrentWeather

   override suspend fun fetchCurrentWeather(location: String) {
      try {
         val fetchedCurrentWeather = weatherApiService
            .getCurrentWeather(location)
            .await()
         _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
      } catch (e: NoConnectivityException) {
         Log.e("Connectivity","No Internet Connection.", e)
      }
   }
}