package com.app.creditscore.data.model

import com.google.gson.annotations.SerializedName

data class CreditScore(
    @SerializedName("accountIDVStatus") val accountIDVStatus: String? = "",
    @SerializedName("dashboardStatus") val dashboardStatus: String? = "",
    @SerializedName("personaType") val personaType: String? = "",
    @SerializedName("creditReportInfo") val creditReportInfo: CreditReport? = CreditReport(),
    @SerializedName("coachingSummary") val coachingSummary: CoachingSummary? = CoachingSummary(),
)

data class CreditReport(
    @SerializedName("clientRef") val clientRef: String? = "",
    @SerializedName("score") val score: Int? = 0,
    @SerializedName("scoreBand") val scoreBand: Int? = 0,
    @SerializedName("status") val status: String? = "",
    @SerializedName("maxScoreValue") val maxScoreValue: Int? = 0,
    @SerializedName("minScoreValue") val minScoreValue: Int? = 0,
    @SerializedName("monthsSinceLastDefaulted") val monthsSinceLastDefaulted: Int? = 0,
    @SerializedName("hasEverDefaulted") val hasEverDefaulted: Boolean? = false,
    @SerializedName("hasEverBeenDelinquent") val hasEverBeenDelinquent: Boolean? = false,
    @SerializedName("monthsSinceLastDelinquent") val monthsSinceLastDelinquent: Int? = 0,
    @SerializedName("percentageCreditUsed") val percentageCreditUsed: Int? = 0,
    @SerializedName("percentageCreditUsedDirectionFlag") val percentageCreditUsedDirectionFlag: Int? = 0,
    @SerializedName("changedScore") val changedScore: Int? = 0,
    @SerializedName("currentShortTermDebt") val currentShortTermDebt: Long? = 0,
    @SerializedName("currentShortTermNonPromotionalDebt") val currentShortTermNonPromotionalDebt: Long? = 0,
    @SerializedName("currentShortTermCreditLimit") val currentShortTermCreditLimit: Long? = 0,
    @SerializedName("currentShortTermCreditUtilisation") val currentShortTermCreditUtilisation: Long? = 0,
    @SerializedName("changeInShortTermDebt") val changeInShortTermDebt: Long? = 0,
    @SerializedName("currentLongTermNonPromotionalDebt") val currentLongTermNonPromotionalDebt: Long? = 0,
    @SerializedName("currentLongTermCreditLimit") val currentLongTermCreditLimit: Long? = 0,
    @SerializedName("currentLongTermCreditUtilisation") val currentLongTermCreditUtilisation: Long? = 0,
    @SerializedName("changeInLongTermDebt") val changeInLongTermDebt: Long? = 0,
    @SerializedName("numPositiveScoreFactors") val numPositiveScoreFactors: Long? = 0,
    @SerializedName("numNegativeScoreFactors") val numNegativeScoreFactors: Long? = 0,
    @SerializedName("equifaxScoreBand") val equifaxScoreBand: Long? = 0,
    @SerializedName("equifaxScoreBandDescription") val equifaxScoreBandDescription: String? = "",
    @SerializedName("daysUntilNextReport") val daysUntilNextReport: Int? = 0,
)

data class CoachingSummary(
    @SerializedName("activeTodo") val activeTodo: Boolean? = false,
    @SerializedName("activeChat") val activeChat: Boolean? = false,
    @SerializedName("numberOfTodoItems") val numberOfTodoItems: Int? = 0,
    @SerializedName("numberOfCompletedTodoItems") val numberOfCompletedTodoItems: Int? = 0,
    @SerializedName("selected") val selected: Boolean? = false,
)