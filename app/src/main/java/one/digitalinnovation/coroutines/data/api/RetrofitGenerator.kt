package one.digitalinnovation.coroutines.data.api

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitGenerator {

    private val moshi = Moshi.Builder()
        .build()

    private val client = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().setLevel(Level.BODY)
        )
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .client(client)
        .addConverterFactory(
            MoshiConverterFactory.create(moshi)
        )
        .build()

    val viaCepService by lazy {
        retrofit.create<ViaCepService>()
    }
}