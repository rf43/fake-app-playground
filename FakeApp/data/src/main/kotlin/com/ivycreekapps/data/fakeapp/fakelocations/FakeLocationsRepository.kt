package com.ivycreekapps.data.fakeapp.fakelocations

import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation

class FakeLocationsRepository(
    private val locationPersistenceSource: FakeLocationPersistenceSource,
    private val deviceLocationSource: FakeDeviceLocationSource
) {
    fun getSavedFakeRawLocations(): List<FakeRawLocation> = locationPersistenceSource.getPersistedFakeRawLocations()

    fun requestNewFakeRawLocations(): List<FakeRawLocation> {
        val newLocation = deviceLocationSource.getFakeDeviceLocation()
        locationPersistenceSource.saveNewFakeRawLocation(newLocation)
        return getSavedFakeRawLocations()
    }
}

interface FakeLocationPersistenceSource {
    fun getPersistedFakeRawLocations(): List<FakeRawLocation>
    fun saveNewFakeRawLocation(fakeRawLocation: FakeRawLocation)
}

interface FakeDeviceLocationSource {
    fun getFakeDeviceLocation(): FakeRawLocation
}