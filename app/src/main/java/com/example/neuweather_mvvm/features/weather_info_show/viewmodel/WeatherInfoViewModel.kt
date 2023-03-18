package com.example.neuweather_mvvm.features.weather_info_show.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.neuweather_mvvm.common.RequestCompleteListener
import com.example.neuweather_mvvm.features.weather_info_show.model.WeatherInfoShowModel
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.City
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherDataModel
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherInfoResponse
import com.example.neuweather_mvvm.utils.kelvinToCelsius
import com.example.neuweather_mvvm.utils.unixTimestampToDateTimeString
import com.example.neuweather_mvvm.utils.unixTimestampToTimeString

class WeatherInfoViewModel: ViewModel() {
    val cityListLiveData = MutableLiveData<MutableList<City>>()
    val cityListFailureLiveData = MutableLiveData<String>()
    val weatherInfoLiveData = MutableLiveData<WeatherDataModel>()
    val weatherInfoFailureLiveData = MutableLiveData<String>()
    val progressBarLiveData = MutableLiveData<Boolean>()

    fun getCityList(model: WeatherInfoShowModel) {
        //calling model's method for city list
        model.getCityList(object : RequestCompleteListener<MutableList<City>> {

            // if model successfully fetch the data from 'somewhere', this method will be called
            override fun onRequestSuccess(data: MutableList<City>) {
                cityListLiveData.postValue(data)
            }

            // if model failed to fetch data this will be called
            override fun onRequestFailed(errorMessage: String) {
                cityListFailureLiveData.postValue(errorMessage)
            }

        })
    }

    //calling model's method for city list
    fun getWeatherInfo(cityId: Int, model: WeatherInfoShowModel) {
        //notifying view about progressbar visibility
        progressBarLiveData.postValue(true)

        //calling model for weather information
        model.getWeatherInformation(cityId,
            object : RequestCompleteListener<WeatherInfoResponse> {
            //if model fetches data from "somewhere"
            override fun onRequestSuccess(data: WeatherInfoResponse) {

                //data formatting on behalf of UI
                val weatherData = WeatherDataModel(
                    dateTime = data.dt.unixTimestampToDateTimeString(),
                    temperature = data.main.temp.kelvinToCelsius().toString(),
                    cityAndCountry = "${data.name}, ${data.sys.country}",
                    weatherConditionIconUrl = "http://openweathermap.org/img/w/${data.weather[0].icon}.png",
                    weatherConditionIconDescription = data.weather[0].description,
                    humidity = "${data.main.humidity}%",
                    pressure = "${data.main.pressure} mBar",
                    visibility = "${data.visibility/1000.0} KM",
                    sunrise = data.sys.sunrise.unixTimestampToTimeString(),
                    sunset = data.sys.sunset.unixTimestampToTimeString()
                )

                //notifying view about progressbar visibility
                progressBarLiveData.postValue(false)
                //notify view about formatted data
                weatherInfoLiveData.postValue(weatherData)
            }

            //if model failed to fetch data
            override fun onRequestFailed(errorMessage: String) {
                //notifying view about progressbar visibility
                progressBarLiveData.postValue(false)

                //notify view about data failure
                weatherInfoFailureLiveData.postValue(errorMessage)
            }
        })
    }

}