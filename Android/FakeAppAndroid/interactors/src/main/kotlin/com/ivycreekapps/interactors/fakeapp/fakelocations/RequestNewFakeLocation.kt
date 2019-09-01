package com.ivycreekapps.interactors.fakeapp.fakelocations

import com.ivycreekapps.data.fakeapp.fakelocations.FakeLocationsRepository
import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation

class RequestNewFakeLocations(private val locationsRepository: FakeLocationsRepository) {
    operator fun invoke(): List<FakeRawLocation> = locationsRepository.requestNewFakeRawLocations()
}