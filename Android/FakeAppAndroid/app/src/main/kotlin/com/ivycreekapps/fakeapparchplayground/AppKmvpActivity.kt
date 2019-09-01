package com.ivycreekapps.fakeapparchplayground

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.ivycreekapps.fakeapparchplayground.kmvp.*

abstract class AppKmvpActivity<TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TViewModel : IViewModel> :
    KmvpActivity<TPresenterViewUi, TPresenter, TViewModel>(),
    IViewUi {

    @get:LayoutRes
    protected abstract val layoutRes: Int

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }
}