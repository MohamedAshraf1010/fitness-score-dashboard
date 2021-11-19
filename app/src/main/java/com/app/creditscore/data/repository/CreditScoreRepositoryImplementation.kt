package com.app.creditscore.data.repository

import com.app.creditscore.data.api.CreditScoreAPIs
import com.app.creditscore.data.model.CreditScore
import com.app.creditscore.domain.respository.CreditScoreRepository
import retrofit2.Retrofit

class CreditScoreRepositoryImplementation constructor(retrofit: Retrofit) : CreditScoreRepository
{
    private val apis = retrofit.create(CreditScoreAPIs::class.java)

    private var creditScore: CreditScore? = null

    override fun getCachedCreditScore(): CreditScore? = creditScore

    override suspend fun getCreditScore(): CreditScore
    {
        val creditScore = apis.endpoint()
        this@CreditScoreRepositoryImplementation.creditScore = creditScore
        return creditScore
    }
}