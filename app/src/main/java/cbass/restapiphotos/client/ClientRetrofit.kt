package cbass.restapiphotos.client

import cbass.restapiphotos.service.PhotosService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ClientRetrofit {

    companion object
    {
        val base_url = "https://jsonplaceholder.typicode.com/"

        fun getInstance(baseUrl:String):PhotosService
        {
            val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit.create(PhotosService::class.java)
        }
    }
}