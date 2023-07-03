package com.example.retrofitdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Albums
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        val responseLiveData = liveData {
            val response = retrofitService.getAlbumsList()
            emit(response)
        }

        responseLiveData.observe(this, Observer {

            val albumsList = it.body()?.listIterator()

            albumsList?.let {
                for(albumItem in it){
                    Log.d("TAGY","${albumItem.id} ${albumItem.userId} ${albumItem.title}")

                }
            }


        })


    }
}