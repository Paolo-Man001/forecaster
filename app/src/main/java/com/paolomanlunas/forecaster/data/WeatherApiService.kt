package com.paolomanlunas.forecaster.data

import android.provider.Settings.Global.getString
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.paolomanlunas.forecaster.BuildConfig
import com.paolomanlunas.forecaster.R
import com.paolomanlunas.forecaster.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = BuildConfig.WeatherApiKey
// http://api.weatherstack.com/current?access_key=API_KEY&query=Wellington&language=en
/*
* http://api.weatherstack.com/current
    ? access_key = YOUR_ACCESS_KEY
    & query = New York

// optional parameters:

    & units = m
    & language = en
    & callback = MY_CALLBACK
* */


interface WeatherApiService {

   @GET("current")
   fun getCurrentWeather(
      @Query("query") location: String
//      @Query("language") languageCode: String = "en"
   ): Deferred<CurrentWeatherResponse>

   companion object {
      operator fun invoke(): WeatherApiService {
         val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
               .url()
               .newBuilder()
               .addQueryParameter("access_key", API_KEY)
               .build()
            val request = chain.request()
               .newBuilder()
               .url(url)
               .build()

            return@Interceptor chain.proceed(request)
         }

         val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()

         return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://api.weatherstack.com/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
      }
   }
}