package com.example.neuweather_mvvm.features.weather_info_show.model

import android.content.Context
import com.example.neuweather_mvvm.common.RequestCompleteListener
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.City
import com.example.neuweather_mvvm.features.weather_info_show.model.data_class.WeatherInfoResponse
import com.example.neuweather_mvvm.network.ApiInterface
import com.example.neuweather_mvvm.network.RetrofitClient
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOError
import java.io.IOException
import java.nio.Buffer

class WeatherInfoShowModelImpl (private val context: Context): WeatherInfoShowModel {

    /**
     * Fetching City List From Local Storage
     * Model only knows about data source
     * Knows nothing about data validation, logic handling or view
     * */

    override fun getCityList(callback: RequestCompleteListener<MutableList<City>>) {
        try {
            val stream = context.assets.open("city_list.json")

            val size = stream.available()
            val buffer= ByteArray(size)
            stream.read(buffer)
            stream.close()

            val tContents = String(buffer)

            val groupListType = object : TypeToken<ArrayList<City>>(){}.type
            val gson = GsonBuilder().create()
            val cityList: MutableList<City> = gson.fromJson(tContents, groupListType)

            callback.onRequestSuccess(cityList) //notified presenter about data
        }
        catch (e: IOException){
            e.printStackTrace()
            callback.onRequestFailed(e.localizedMessage!!)
        }
    }

    /**
     * Fetching weather information from server (remote) using http network request
     * only knows about data source and fetching information from data sources
     * It wont' validate data
     * Only will notify PRESENTER about the raw data
     * Then presenter will hold logic to validate the data
     * and will decide what to show in the UI and notify the view about it
     * */

    override fun getWeatherInformation(
        cityId: Int,
        callback: RequestCompleteListener<WeatherInfoResponse>
    ) {
        val apiInterface: ApiInterface = RetrofitClient.client.create(ApiInterface::class.java)
        val call : Call<WeatherInfoResponse> = apiInterface.callApiForWeatherInfo(cityId)

        call.enqueue(object : Callback<WeatherInfoResponse>{
            override fun onResponse(
                call: Call<WeatherInfoResponse>,
                response: Response<WeatherInfoResponse>
            ) {
                if (response.body() != null){
                    callback.onRequestSuccess(response.body()!!)
                }
                else callback.onRequestFailed(response.message())
            }

            override fun onFailure(call: Call<WeatherInfoResponse>, t: Throwable) {
                callback.onRequestFailed(t.localizedMessage!!)
            }
        })
    }
}