package com.ivycreekapps.fakeapparchplayground.kmvp

import androidx.annotation.CallSuper

abstract class KmvpPresenter<TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>, TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>, TViewModel : IViewModel>(
    override val presenterViewUi: TPresenterViewUi
) : IPresenter<TPresenter, TPresenterViewUi, TViewModel> {

    override var backingViewModel: TViewModel? = null
    override var viewModel: TViewModel
        get() = backingViewModel ?: throw IllegalStateException("ViewModel cannot be null")
        set(value) {
            val oldViewModel = backingViewModel
            backingViewModel = value
            onViewModelUpdate(oldViewModel)
        }

    @CallSuper
    open fun onCreate() {
    }

    @CallSuper
    open fun onResume() {
    }

    @CallSuper
    open fun onPause() {
    }

    @CallSuper
    open fun onDestroy() {
    }

    abstract fun onViewModelUpdate(oldViewModel: TViewModel?)
}