package com.plcoding.testingcourse.part4.data

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.plcoding.testingcourse.part4.domain.AnalyticsLogger

class FirebaseAnalyticsLogger(
    private val analytics: FirebaseAnalytics = Firebase.analytics
): AnalyticsLogger {
    override fun logEvent(key: String, vararg params: AnalyticsLogger.LogParam<Any>) {
        analytics.logEvent(key) {
            params.forEach { parameter ->
                param(parameter.key, parameter.value.toString())
            }
        }
    }
}