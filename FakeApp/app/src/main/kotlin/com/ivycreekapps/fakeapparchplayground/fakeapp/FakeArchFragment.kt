package com.ivycreekapps.fakeapparchplayground.fakeapp

import com.ivycreekapps.fakeapparchplayground.AppKmvpFragment
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.kmvp.IViewModel
import com.ivycreekapps.fakeapparchplayground.kmvp.KmvpPresenter

class FakeArchFragPresenter(fakeArchFragment: FakeArchFragment) :
    KmvpPresenter<FakeArchFragPresenter, FakeArchFragment, FakeArchFragViewModel>(fakeArchFragment) {

    override fun onViewModelUpdate(oldViewModel: FakeArchFragViewModel?) {

    }
}

// Since this is just a base empty default fragment
// we'll just make it all self-contained (fragment, presenter, viewmodel)
class FakeArchFragment : AppKmvpFragment<FakeArchFragment, FakeArchFragPresenter, FakeArchFragViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_fake_app_default

    override fun createPresenter(): FakeArchFragPresenter {
        return FakeArchFragPresenter(this)
    }

    override fun renderViewModel(viewModel: FakeArchFragViewModel) {

    }
}

class FakeArchFragViewModel : IViewModel