package com.paolomanlunas.forecaster.data.network.response

import com.google.gson.annotations.SerializedName
import com.paolomanlunas.forecaster.data.db.entity.CurrentWeatherEntry
import com.paolomanlunas.forecaster.data.db.entity.Location
import com.paolomanlunas.forecaster.data.db.entity.Request


data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location,
    val request: Request
)