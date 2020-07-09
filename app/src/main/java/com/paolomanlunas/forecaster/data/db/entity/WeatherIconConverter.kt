package com.paolomanlunas.forecaster.data.db.entity

import androidx.room.TypeConverter

class WeatherIconConverter {
   @TypeConverter
   fun fromWeatherIconList(value: String):List<String>{
      return  value.split(",").map { it }
   }

   @TypeConverter
   fun toWeatherIconString(value: List<String>): String {
      return value.joinToString(separator = ",")
   }
}