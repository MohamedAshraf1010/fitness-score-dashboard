package com.app.creditscore.domain.respository

import com.app.creditscore.data.model.CreditScore

interface CreditScoreRepository
{
    fun getCachedCreditScore(): CreditScore?

    suspend fun getCreditScore(): CreditScore
}