package com.paolomanlunas.forecaster.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.paolomanlunas.forecaster.data.db.entity.CurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun upsert(weatherEntry: CurrentWeatherEntry)
}