package com.app.creditscore.presentation.main

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import com.app.creditscore.R
import com.app.creditscore.data.model.CreditScore
import com.app.creditscore.databinding.ActivityMainBinding
import com.app.creditscore.presentation.base.BaseActivity
import com.app.creditscore.utils.setGradientTextColor
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity()
{
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.state.observe(this@MainActivity, { setViewState(it) })
    }

    override fun onResume()
    {
        super.onResume()
        viewModel.intent.value = MainViewIntents.GetCreditScoreIntent
    }

    override fun onDestroy()
    {
        super.onDestroy()
        viewModel.clear()
    }

    private fun setViewState(state: MainViewState)
    {
        when (state)
        {
            is MainViewState.DataState -> setData(state.score)
            is MainViewState.ErrorState -> showError(state.error.message ?: getString(R.string.error))
            is MainViewState.LoadingState -> showLoading()
        }
    }

    private fun setData(score: CreditScore)
    {
        dismissLoading()
        binding.progress.max = score.creditReportInfo?.maxScoreValue ?: 100
        binding.progress.progress = score.creditReportInfo?.score ?: 0
        binding.scoreHeader.text = getString(R.string.score_header)
        binding.score.text = "${score.creditReportInfo?.score ?: 0}"
        binding.score.setGradientTextColor(intArrayOf(Color.parseColor("#FFAB40"), Color.parseColor("#EEFF41")))
        binding.scoreFooter.text = getString(R.string.score_footer, score.creditReportInfo?.maxScoreValue ?: 100)
        binding.status.text = getString(R.string.status, score.dashboardStatus ?: "")
        binding.scoreDescription.text = getString(R.string.score_description, score.creditReportInfo?.equifaxScoreBandDescription ?: "")
        val animation = ObjectAnimator.ofInt(binding.progress, "progress", 0, score.creditReportInfo?.score ?: 0)
        animation.duration = 700
        animation.start()
    }

    private fun showError(error: String)
    {
        dismissLoading()
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
    }
}