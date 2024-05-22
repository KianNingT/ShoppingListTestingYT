package com.plcoding.testingcourse.part4.presentation

import com.plcoding.testingcourse.part4.domain.AnalyticsLogger
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class GoodProfileViewModelTest {

    private lateinit var viewmodel: GoodProfileViewModel
    @BeforeEach
    fun setup() {
        viewmodel = GoodProfileViewModel(
            analytics = object : AnalyticsLogger {
                override fun logEvent(key: String, vararg params: AnalyticsLogger.LogParam<Any>) {

                }

            }
        )
    }
}