package cbass.restapiphotos.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbass.restapiphotos.client.ClientRetrofit
import cbass.restapiphotos.model.Photos
import cbass.restapiphotos.model.PhotosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosVM(application: Application):AndroidViewModel(application) {

    val photos = MutableLiveData<Photos>()
    val photosItem = MutableLiveData<PhotosItem>()

    fun getData()
    {
        val service = ClientRetrofit.getInstance(ClientRetrofit.base_url)
        service.getPhotos().enqueue(object : Callback<Photos>{
            override fun onResponse(call: Call<Photos>, response: Response<Photos>) {
                response.body().let {
                    photos.postValue(it)
                    Log.d("API",response.body().toString())
                }
            }

            override fun onFailure(call: Call<Photos>, t: Throwable) {
                Log.e("CALL", t.message.toString())

            }

        })
    }
}