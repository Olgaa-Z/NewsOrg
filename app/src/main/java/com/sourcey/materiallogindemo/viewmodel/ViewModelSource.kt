package com.sourcey.materiallogindemo.viewmodel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sourcey.materiallogindemo.api.ApiService
import com.sourcey.materiallogindemo.model.source.ResponseSource
import com.sourcey.materiallogindemo.model.source.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelSource @Inject constructor(var api : ApiService) : ViewModel(){

    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource(): MutableLiveData<List<Source>?> {
        return  liveDataSource
    }

    fun callApiSource(categ : String, context: Context){
        api.getAllSources(categ)
            .enqueue(object : Callback<ResponseSource>{
                override fun onResponse(
                    call: Call<ResponseSource>,
                    response: Response<ResponseSource>
                ) {
                    if (response.isSuccessful){
                            liveDataSource.postValue(response.body()!!.sources)
                            Log.d(TAG, "onResponse: ${response.body()!!.sources.size}")
                    }else{
                        Log.d(TAG, "onResponse: Unsuccessfully")
                        liveDataSource.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseSource>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                    liveDataSource.postValue(null)
                }

            })
    }


}