package com.fusemachines.flower_retrofit.model

import com.fusemachines.flower_retrofit.PictureContract
import com.fusemachines.flower_retrofit.api.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureModel : PictureContract.PictureModel {

    override fun getPicturesFromApi(listener: PictureContract.ModelListener) {
        val response = RestApi.RestApi().getFlower()

        response.enqueue(object : Callback<List<PictureDetail>> {

            override fun onResponse(call: Call<List<PictureDetail>>?, response: Response<List<PictureDetail>>?) {
                listener.onSuccess(response!!.body()!!.toList())

            }

            override fun onFailure(call: Call<List<PictureDetail>>?, t: Throwable?) {
                listener.onError(t?.message.toString())
            }



        })

    }

}