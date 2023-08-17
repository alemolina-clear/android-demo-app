package com.bonzzu.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bonzzu.demo.api.DemoApi
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity: AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)
    val gson = GsonBuilder()
      .setLenient()
      .create()
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS)
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient
      .Builder()
      .addInterceptor(loggingInterceptor)
      .build()
    val retro = Retrofit
      .Builder()
      .baseUrl(DemoApi.BASE)
      .client(client)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .build()
      .create(DemoApi::class.java)



    getPokemonDataWithCoroutine(retro)
  }

  private fun getPokemonDataWithCoroutine(retro: DemoApi) {
    CoroutineScope(Dispatchers.IO).launch{
      getPokemonData(retro)
    }
  }

  suspend fun getPokemonData(demoApi: DemoApi) {
    withContext(Dispatchers.IO) {
      try {
        val pokemon = demoApi.getBaseData()
        println(" pokemon: $pokemon.name , Index= ${pokemon.gameIndexes.last()} ")
      } catch (e: Exception) {
        println("Exception fetching data")
      }
    }
  }
}