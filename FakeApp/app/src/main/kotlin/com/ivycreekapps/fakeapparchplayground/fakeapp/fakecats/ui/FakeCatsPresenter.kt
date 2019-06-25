package com.ivycreekapps.fakeapparchplayground.fakeapp.fakecats.ui

import android.util.Log
import com.ivycreekapps.fakeapparchplayground.kmvp.IViewModel
import com.ivycreekapps.fakeapparchplayground.kmvp.KmvpPresenter

class FakeCatsViewModel : IViewModel {
    init {
        Log.i("FakeCatsViewModel", "*** ---> INIT <--- ***")
    }
}

class FakeCatsPresenter(
    private val fakeCatsViewUi: FakeCatsFragment
) : KmvpPresenter<FakeCatsPresenter, FakeCatsFragment, FakeCatsViewModel>(fakeCatsViewUi) {

    override var viewModel = FakeCatsViewModel()

    init {
        Log.i("FakeLocationPresenter", "*** ---> INIT <--- ***")
    }

    override fun onViewModelUpdate(oldViewModel: FakeCatsViewModel?) {

    }
}