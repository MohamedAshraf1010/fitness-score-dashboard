package com.app.creditscore

import com.app.creditscore.data.model.CreditReport
import com.app.creditscore.data.model.CreditScore
import com.app.creditscore.domain.respository.CreditScoreRepository
import com.app.creditscore.domain.usecase.GetCreditScore
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetCreditScoreTest
{
    private lateinit var getCreditScore: GetCreditScore
    private lateinit var repository: CreditScoreRepository

    @Before
    fun initRepository()
    {
        repository = Mockito.mock(CreditScoreRepository::class.java)
        getCreditScore = GetCreditScore(repository)
    }

    @Test
    fun testGetCreditScore() {
        runBlocking {
            Mockito.`when`(repository.getCreditScore()).thenReturn(CreditScore(accountIDVStatus = "PASS", creditReportInfo = CreditReport(clientRef = "ASD-364-SDW", score = 100, maxScoreValue = 500)))

            // No business logic so expected should returned without changes
            val actualResult = getCreditScore.run()
            Assert.assertNotNull(actualResult.creditReportInfo)
            Assert.assertNotNull(actualResult.creditReportInfo?.clientRef)
            Assert.assertEquals(100, actualResult.creditReportInfo?.score)
            Assert.assertEquals(500, actualResult.creditReportInfo?.maxScoreValue)
        }
    }
}