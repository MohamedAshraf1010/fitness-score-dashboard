package com.app.creditscore.presentation.main

import com.app.creditscore.domain.usecase.GetCreditScore
import com.app.creditscore.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel constructor(private val getCreditScore: GetCreditScore) : BaseViewModel<MainViewState, MainViewIntents>()
{
    init
    {
        observeIntents {
            when (it)
            {
                is MainViewIntents.GetCreditScoreIntent -> getCreditScore()
            }
        }
    }

    private fun getCreditScore() = CoroutineScope(Dispatchers.IO).launch {
        state.postValue(MainViewState.LoadingState)
        try
        {
            val score = getCreditScore.run()
            state.postValue(MainViewState.DataState(score))
        }
        catch (ex: Throwable)
        {
            ex.printStackTrace()
            state.postValue(MainViewState.ErrorState(ex))
        }
    }
}