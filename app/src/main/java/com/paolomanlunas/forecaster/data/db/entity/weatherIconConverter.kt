package com.paolomanlunas.forecaster.data.db.entity

import androidx.room.TypeConverter

class weatherIconConverter {
   @TypeConverter
   fun fromWeatherIconList(value: String):List<String>{
      return  value.split(",").map { it }
   }

   @TypeConverter
   fun toWeatherIconString(value: List<String>): String {
      return value.joinToString(separator = ",")
   }
}