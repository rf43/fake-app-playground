package com.ivycreekapps.fakeapparchplayground.kmvp

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

abstract class KmvpActivity<
        TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TViewModel : IViewModel> :
    AppCompatActivity(),
    IPresenterActivity<TPresenterViewUi, TPresenter, TViewModel> {

    override var backingPresenter: TPresenter? = null
    override val presenter: TPresenter
        get() = backingPresenter ?: throw IllegalStateException("Presenter cannot be null")

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        backingPresenter = createPresenter()
    }

    @CallSuper
    override fun onDestroy() {
        backingPresenter = null
        super.onDestroy()
    }
}