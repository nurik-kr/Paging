package kg.nurik.pagination.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

//    private var service: SharesService? = null когда у нас идет KOIN не надо его тут реализовать, он сам его реализует
//
//    fun getService(): SharesService? { // singleTon мы там прописали тут уже не надо
//        if (service == null) service =
//            buildRetrofit()
//
//        return service
//    }

    fun buildRetrofit(): SharesService {
        return Retrofit.Builder()
            .baseUrl("http://api.marketstack.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
            .create(SharesService::class.java)
    }

    fun getClient(): OkHttpClient { //библ предоставляет по работе с http запросами , умеет что-то подставлять в заголовки
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(providerLoginInterceptor())
            .build()
    }

    private fun providerLoginInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }
}