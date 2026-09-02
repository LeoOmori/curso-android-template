package com.example.template.helper

import com.example.template.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Cria e mantém uma única instância do Retrofit para o app inteiro.
 *
 * `object` = singleton em Kotlin. `by lazy` só constrói o objeto na
 * primeira vez que ele é usado.
 */
object RetrofitInstance {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Loga no Logcat o corpo de cada requisição/resposta em builds de debug.
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
