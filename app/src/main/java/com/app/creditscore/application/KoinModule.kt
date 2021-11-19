package com.app.creditscore.application

import com.app.creditscore.BuildConfig
import com.app.creditscore.domain.usecase.*
import com.app.creditscore.data.repository.*
import com.app.creditscore.domain.respository.*
import com.app.creditscore.presentation.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val koinModule = module {
    single { provideRetrofit() }

    single { CreditScoreRepositoryImplementation(get()) as CreditScoreRepository }

    single { GetCreditScore(get()) }

    viewModel { MainViewModel(get()) }

}

fun provideRetrofit(): Retrofit
{
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build()
}