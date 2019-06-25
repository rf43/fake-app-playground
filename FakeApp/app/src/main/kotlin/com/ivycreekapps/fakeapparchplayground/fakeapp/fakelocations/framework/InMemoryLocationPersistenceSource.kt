package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.framework

import com.ivycreekapps.data.fakeapp.fakelocations.FakeLocationPersistenceSource
import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation

class InMemoryLocationPersistenceSource : FakeLocationPersistenceSource {

    private var locations: MutableList<FakeRawLocation> = mutableListOf()

    override fun getPersistedFakeRawLocations(): List<FakeRawLocation> = locations

    override fun saveNewFakeRawLocation(fakeRawLocation: FakeRawLocation) {
        locations.add(fakeRawLocation)
    }

}