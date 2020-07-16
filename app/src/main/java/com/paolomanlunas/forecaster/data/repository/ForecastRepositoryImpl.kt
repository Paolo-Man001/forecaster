package com.paolomanlunas.forecaster.data.repository

import androidx.lifecycle.LiveData
import com.paolomanlunas.forecaster.data.db.CurrentWeatherDao
import com.paolomanlunas.forecaster.data.db.entity.CurrentWeatherEntry
import com.paolomanlunas.forecaster.data.network.WeatherNetworkDataSource

class ForecastRepositoryImpl(
   private val currentWeatherDao: CurrentWeatherDao,
   private val weatherNetworkDataSource: WeatherNetworkDataSource
) : ForecastRepository {
   override suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry> {
      TODO("Not yet implemented")
   }
}