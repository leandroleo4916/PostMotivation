package com.example.postmotivation.di

import com.example.portaldatransparencia.network.*
import com.example.portaldatransparencia.repository.*
import com.example.portaldatransparencia.util.*
import com.example.portaldatransparencia.views.camara.CamaraViewModel
import com.example.portaldatransparencia.views.view_generics.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
        single<Retrofit> {
                Retrofit.Builder()
                        .baseUrl("https://dadosabertos.camara.leg.br")
                        .client(get())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        }
        single {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                OkHttpClient.Builder()
                        .addInterceptor(logging)
                        .build()
        }
        single<ApiServiceMain> { get<Retrofit>().create(ApiServiceMain::class.java) }
}

val repositorySearch = module { single { SearchRepository(get()) } }

val cotaState = module { factory { CotaState() }}

val viewModelModule = module { viewModel { CamaraViewModel(get()) } }


val appModules = listOf(
)