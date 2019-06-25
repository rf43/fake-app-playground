package com.ivycreekapps.fakeapparchplayground.fakeapp.fakenotes.ui

import com.ivycreekapps.fakeapparchplayground.AppKmvpFragment
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.kmvp.IViewModel
import com.ivycreekapps.fakeapparchplayground.kmvp.KmvpPresenter

class FakeNotesFragment : AppKmvpFragment<FakeNotesFragment, FakeNotesPresenter, FakeNotesViewModel>() {
    override val layoutRes: Int
        get() = R.layout.fragment_fake_notes

    override fun createPresenter(): FakeNotesPresenter {
        return FakeNotesPresenter(this)
    }

    override fun renderViewModel(viewModel: FakeNotesViewModel) {

    }
}

class FakeNotesPresenter(private val fakeNotesViewUi: FakeNotesFragment) :
    KmvpPresenter<FakeNotesPresenter, FakeNotesFragment, FakeNotesViewModel>(fakeNotesViewUi) {

    override fun onViewModelUpdate(oldViewModel: FakeNotesViewModel?) {

    }
}

class FakeNotesViewModel : IViewModel