package com.ivycreekapps.fakeapparchplayground.kmvp

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class KmvpFragment<TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TViewModel : IViewModel> :
    Fragment(),
    IPresenterFragment<TPresenterViewUi, TPresenter, TViewModel> {

    override var backingPresenter: TPresenter? = null
    override val presenter: TPresenter
        get() = backingPresenter ?: throw IllegalStateException("Presenter cannot be null")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backingPresenter = createPresenter()
    }

    override fun onDestroy() {
        backingPresenter = null
        super.onDestroy()
    }
}