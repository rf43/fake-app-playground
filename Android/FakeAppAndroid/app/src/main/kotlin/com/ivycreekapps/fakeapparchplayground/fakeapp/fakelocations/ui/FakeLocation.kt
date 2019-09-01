package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.ui

import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Data object that contains the fake location
 * data suitable for UI presentation
 */
data class FakeLocation(val coordinates: String, val date: String)

/**
 * Extension method to convert a FakeRawLocation object
 * into a FakeLocation object suitable for presentation
 */
fun FakeRawLocation.toPresentationModel(): FakeLocation =
    FakeLocation(
        "${latitude.toPrettifiedString()} | ${longitude.toPrettifiedString()}",
        date.toPrettifiedString()
    )

/**
 * Extension method to convert the date to a human
 * readable format
 */
private fun Date.toPrettifiedString(): String =
    SimpleDateFormat.getTimeInstance().run { format(this@toPrettifiedString) }

/**
 * Extension method to convert the fake location into a
 * human readable formatted string
 */
private fun Double.toPrettifiedString(): String {
    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this)
}