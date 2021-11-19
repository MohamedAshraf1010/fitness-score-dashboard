package com.app.creditscore.utils

import android.graphics.LinearGradient
import android.graphics.Shader
import android.view.View
import android.widget.TextView

fun TextView.setGradientTextColor(intArray: IntArray)
{
    val textShader: Shader = LinearGradient(0f, 0f, 0f, height.toFloat(), intArray, null, Shader.TileMode.REPEAT)
    this.paint.shader = textShader
}

fun TextView.setTextWithVisibilityCheck(text: String)
{
    if (text.isEmpty())
    {
        this.text = ""
        this.visibility = View.GONE
    }
    else
    {
        this.text = text
        this.visibility = View.VISIBLE
    }
}