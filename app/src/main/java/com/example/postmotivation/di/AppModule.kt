package com.example.postmotivation.di

import com.example.postmotivation.network.ApiServiceMain
import com.example.postmotivation.repository.RepositoryPage
import com.example.postmotivation.viewModel.ViewModelPage
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
        single<Retrofit> {
                Retrofit.Builder()
                        .baseUrl("https://api.pexels.com/v1/")
                        .client(get())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        }
        single {
                OkHttpClient.Builder().addInterceptor { chain ->
                        val newRequest: Request = chain.request().newBuilder()
                                .addHeader(
                                        "Authorization",
                                        "f1rRs6PhJfHy90J3mI9dPvwJzQ8Gg9TJI5MCw7CkOIO8NVq6vAltIzJC"
                                )
                                .build()
                        chain.proceed(newRequest)
                }.build()
        }
        single<ApiServiceMain> { get<Retrofit>().create(ApiServiceMain::class.java) }
}

val repositoryPage = module { single { RepositoryPage(get()) } }
val viewModelModule = module { viewModel { ViewModelPage(get()) } }

val appModules = listOf(
        retrofitModule, viewModelModule, repositoryPage
)