package com.paolomanlunas.forecaster.ui.weather.current

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.paolomanlunas.forecaster.R
import com.paolomanlunas.forecaster.data.network.ConnectivityInterceptorImpl
import com.paolomanlunas.forecaster.data.network.WeatherApiService
import com.paolomanlunas.forecaster.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

   companion object {
      fun newInstance() =
         CurrentWeatherFragment()
   }

   private lateinit var viewModel: CurrentWeatherViewModel

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.current_weather_fragment, container, false)
   }

   override fun onActivityCreated(savedInstanceState: Bundle?) {
      super.onActivityCreated(savedInstanceState)
      viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
      // TODO: Use the ViewModel

      val apiService = WeatherApiService(ConnectivityInterceptorImpl(this.requireContext()))
      val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

      // Observe the property in weatherNetworkDataSource
      weatherNetworkDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
         textView.text = it.toString()                                  // currentWeatherResponse Object
//         textView.text = it.currentWeatherEntry.weatherDescriptions[0]  // Weather Desc. Only
//         textView.text = it.currentWeatherEntry.toString()              // currentWeatherEntry Object Only
      })

      GlobalScope.launch(Dispatchers.Main) {

         weatherNetworkDataSource.fetchCurrentWeather("Wellington")

         /* OLD Demo Code */
/*
         val currentWeatherResponse =
            apiService.getCurrentWeather("Wellington").await()
         textView.text = currentWeatherResponse.currentWeatherEntry.weatherDescriptions[0]    // Weather Desc. Only
         textView.text = currentWeatherResponse.currentWeatherEntry.toString()                // currentWeatherEntry Object Only
         textView.text = currentWeatherResponse.toString()                                      // currentWeatherResponse Object
*/
      }
   }

}