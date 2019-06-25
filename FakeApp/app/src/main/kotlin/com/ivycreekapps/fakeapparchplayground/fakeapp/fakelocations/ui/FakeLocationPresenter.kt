package com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.ui

import android.util.Log
import com.ivycreekapps.domain.fakeapp.fakelocations.FakeRawLocation
import com.ivycreekapps.fakeapparchplayground.kmvp.IViewModel
import com.ivycreekapps.fakeapparchplayground.kmvp.KmvpPresenter
import com.ivycreekapps.interactors.fakeapp.fakelocations.GetFakeLocations
import com.ivycreekapps.interactors.fakeapp.fakelocations.RequestNewFakeLocations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FakeLocationViewModel : IViewModel {
    var locations: List<FakeLocation> = listOf()

    init {
        Log.i("FakeLocationViewModel", "*** ---> INIT <--- ***")
    }
}

class FakeLocationPresenter(
    private val fakeLocationViewUi: FakeLocationFragment,
    private val getLocations: GetFakeLocations,
    private val requestNewFakeLocations: RequestNewFakeLocations
) : KmvpPresenter<FakeLocationPresenter, FakeLocationFragment, FakeLocationViewModel>(fakeLocationViewUi) {

    override var viewModel = FakeLocationViewModel()

    init {
        Log.i("FakeLocationPresenter", "*** ---> INIT <--- ***")
    }

    override fun onViewModelUpdate(oldViewModel: FakeLocationViewModel?) {

    }

    fun newLocationClicked() = GlobalScope.launch(Dispatchers.Main) {
        val result = withContext(Dispatchers.IO) { requestNewFakeLocations() }
        viewModel.locations = result.map(FakeRawLocation::toPresentationModel)
        fakeLocationViewUi.renderViewModel(viewModel)
    }

    private fun newLaunch() = GlobalScope.launch(Dispatchers.Main) {
        val result = withContext(Dispatchers.IO) { getLocations() }
        viewModel.locations = result.map(FakeRawLocation::toPresentationModel)
        fakeLocationViewUi.renderViewModel(viewModel)
    }
}