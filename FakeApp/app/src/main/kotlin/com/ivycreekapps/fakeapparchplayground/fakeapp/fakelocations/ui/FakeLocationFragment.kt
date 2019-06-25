package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivycreekapps.data.fakeapp.fakelocations.FakeLocationsRepository
import com.ivycreekapps.fakeapparchplayground.AppKmvpFragment
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.framework.FakeLocationSource
import com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.framework.InMemoryLocationPersistenceSource
import com.ivycreekapps.interactors.fakeapp.fakelocations.GetFakeLocations
import com.ivycreekapps.interactors.fakeapp.fakelocations.RequestNewFakeLocations

class FakeLocationFragment : AppKmvpFragment<FakeLocationFragment, FakeLocationPresenter, FakeLocationViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_fake_location

    private val locationsAdapter = FakeLocationsAdapter()

    private lateinit var backgroundText: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.fakeLocationsRecyclerView)
        recyclerView.adapter = locationsAdapter

        val newLocationButton: Button = view.findViewById(R.id.newFakeLocationButton)
        newLocationButton.setOnClickListener { presenter.newLocationClicked() }

        backgroundText = view.findViewById(R.id.backgroundText)
    }

    override fun createPresenter(): FakeLocationPresenter {
        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = FakeLocationsRepository(persistence, deviceLocation)

        return FakeLocationPresenter(
            this,
            GetFakeLocations(locationsRepository),
            RequestNewFakeLocations(locationsRepository)
        )
    }

    override fun renderViewModel(viewModel: FakeLocationViewModel) {

    }
}