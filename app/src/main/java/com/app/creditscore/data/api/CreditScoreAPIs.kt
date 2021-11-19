package com.app.creditscore.data.api

import com.app.creditscore.data.model.CreditScore
import retrofit2.http.GET

interface CreditScoreAPIs
{
    @GET("endpoint.json")
    suspend fun endpoint(): CreditScore
}