package com.fusemachines.flower_retrofit.api

import com.fusemachines.flower_retrofit.model.PictureDetail
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RestApi {
    companion object {
        fun RestApi(): RequestAPI {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://services.hanselandpetal.com/feeds/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(RequestAPI::class.java)
        }
    }

    interface RequestAPI {

        @GET("flowers.json")
        fun getFlower(): Call<List<PictureDetail>>

    }
}