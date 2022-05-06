package cbass.restapiphotos.service

import cbass.restapiphotos.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface PhotosService {

    @GET("photos")
    fun getPhotos(): Call<Photos>
}