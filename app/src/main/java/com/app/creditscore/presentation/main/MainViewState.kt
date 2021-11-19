package com.app.creditscore.presentation.main

import com.app.creditscore.data.model.CreditScore

sealed class MainViewState
{
    class DataState(val score: CreditScore) : MainViewState()
    class ErrorState(val error: Throwable) : MainViewState()
    object LoadingState : MainViewState()
}