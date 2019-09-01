package com.ivycreekapps.interactors.fakeapp.fakelocations

import com.ivycreekapps.data.fakeapp.fakelocations.FakeLocationsRepository
import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation

class GetFakeLocations(private val locationsRepository: FakeLocationsRepository) {
    operator fun invoke(): List<FakeRawLocation> = locationsRepository.getSavedFakeRawLocations()
}