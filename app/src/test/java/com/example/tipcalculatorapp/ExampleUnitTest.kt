package com.example.tipcalculatorapp

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun testCalculateTip_withoutRounding() {
        val amount = 10.00
        val tipPercent = 20.0
        var roundUp = false

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)      // tip'in 2 olmasını bekliyoruz

        val actualTip = calculateTip(amount, tipPercent, roundUp)

        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun testCalculateTip_withRounding() {
        val amount = 100.0
        val tipPercent = 15.0
        val roundUp = true

        val expectedTip = NumberFormat.getCurrencyInstance().format(kotlin.math.ceil(tipPercent / 100 * amount))

        val actualTip = calculateTip(amount, tipPercent, roundUp)

        assertEquals(expectedTip, actualTip)
    }
}