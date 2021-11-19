package com.app.creditscore.domain.usecase

import com.app.creditscore.data.model.CreditScore
import com.app.creditscore.domain.respository.CreditScoreRepository

class GetCreditScore constructor(private val repository: CreditScoreRepository)
{
    suspend fun run(): CreditScore = repository.getCachedCreditScore() ?: repository.getCreditScore()
}