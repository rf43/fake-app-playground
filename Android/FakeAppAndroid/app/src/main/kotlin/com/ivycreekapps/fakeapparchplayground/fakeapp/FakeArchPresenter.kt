package com.ivycreekapps.fakeapparchplayground.fakeapp

import androidx.annotation.LayoutRes
import com.ivycreekapps.fakeapparchplayground.kmvp.KmvpPresenter

class FakeArchPresenter(fakeAppActivity: FakeArchActivity) :
    KmvpPresenter<FakeArchPresenter, FakeArchActivity, FakeArchViewModel>(fakeAppActivity) {

    fun setFragment(@LayoutRes layoutRes: Int) {
        viewModel = FakeArchViewModel(layoutRes)
    }

    override fun onViewModelUpdate(oldViewModel: FakeArchViewModel?) {
        presenterViewUi.renderViewModel(viewModel)
    }
}