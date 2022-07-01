package com.example.recyclerviewretrofitcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    val retrofil=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val data = MutableLiveData<List<JsonApiResponse>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jsonApi = retrofil.create(JsonApi::class.java)
        val recyclerView =findViewById<RecyclerView>(R.id.recyclerview)

        get(jsonApi)
        data.observe(this,{
         val adapter=RecyclerAdapter(it)
            recyclerView.adapter=adapter
        })
    }
    fun get(jasonApi:JsonApi){
        CoroutineScope(Dispatchers.IO).launch {
         val response=jasonApi.getPost()
            data.postValue(response.body())
        }
    }
}