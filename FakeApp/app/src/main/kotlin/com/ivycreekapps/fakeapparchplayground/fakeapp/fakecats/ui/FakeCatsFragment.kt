package com.ivycreekapps.fakeapparchplayground.fakeapp.fakecats.ui

import com.ivycreekapps.fakeapparchplayground.AppKmvpFragment
import com.ivycreekapps.fakeapparchplayground.R

class FakeCatsFragment : AppKmvpFragment<FakeCatsFragment, FakeCatsPresenter, FakeCatsViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_fake_cats

    override fun createPresenter(): FakeCatsPresenter {
        return FakeCatsPresenter(this)
    }

    override fun renderViewModel(viewModel: FakeCatsViewModel) {

    }
}