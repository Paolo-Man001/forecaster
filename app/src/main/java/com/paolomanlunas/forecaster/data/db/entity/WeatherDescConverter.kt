package com.paolomanlunas.forecaster.data.db.entity

import androidx.room.TypeConverter

class WeatherDescConverter {
   @TypeConverter
   fun fromWeatherDescList(value: String):List<String>{
      return  value.split(",").map { it }
   }

   @TypeConverter
   fun toWeatherDescString(value: List<String>): String {
      return value.joinToString(separator = ",")
   }
}