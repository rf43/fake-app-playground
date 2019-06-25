package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.framework

import com.ivycreekapps.data.fakeapp.fakelocations.FakeDeviceLocationSource
import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation
import java.util.*
import kotlin.random.Random

class FakeLocationSource : FakeDeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getFakeDeviceLocation(): FakeRawLocation =
        FakeRawLocation(random.nextDouble() * 180 - 90, random.nextDouble() * 360 - 180, Date())
}