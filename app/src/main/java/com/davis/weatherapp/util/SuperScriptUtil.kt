package com.davis.weatherapp.util

import android.text.Html
import android.widget.TextView

object SuperScriptUtil {
    fun getSuperScriptText(textView: TextView, numberToConvert: String?): String {
        var numberToConvert = numberToConvert ?: return ""
        if (numberToConvert.trim { it <= ' ' }.isEmpty()) {
            return ""
        }
        if (numberToConvert.length == 1) {
            numberToConvert += ".0"
        }
        if (numberToConvert.length > 3) {
            numberToConvert = numberToConvert.substring(0, 1)
        }
//        val finalval =
//            numberToConvert[0].toString() + "<sup>" + numberToConvert.substring(1, 3) + "</sup>"
//        //return String.valueOf(Html.fromHtml(finalval));
//        numberToConvert = numberToConvert[0].toString() + "." + numberToConvert[1]
//        var cs = SpannableStringBuilder("X3 + X2")
//        cs = SpannableStringBuilder(numberToConvert)
//        cs.setSpan(SuperscriptSpan(), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        cs.setSpan(RelativeSizeSpan(0.75f), 1, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        textView.text = Html.fromHtml(finalval)
//        textView.text = cs
        var degreesymbol = Html.fromHtml("u00B0").toString()
        var a = Html.fromHtml(numberToConvert + degreesymbol)
        textView.text = a
        return numberToConvert.toString()

    }
}