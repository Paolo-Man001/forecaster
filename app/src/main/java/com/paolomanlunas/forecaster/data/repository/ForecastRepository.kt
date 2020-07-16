package com.paolomanlunas.forecaster.data.repository

import androidx.lifecycle.LiveData
import com.paolomanlunas.forecaster.data.db.entity.CurrentWeatherEntry

interface ForecastRepository {
//   suspend fun getCurrentWeather(metric: Boolean)
   suspend fun getCurrentWeather(): LiveData<CurrentWeatherEntry>
}