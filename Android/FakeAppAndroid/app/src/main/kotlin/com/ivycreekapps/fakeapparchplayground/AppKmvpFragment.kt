package com.ivycreekapps.fakeapparchplayground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.ivycreekapps.fakeapparchplayground.kmvp.*

abstract class AppKmvpFragment<
        TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TViewModel : IViewModel>
    : KmvpFragment<TPresenterViewUi, TPresenter, TViewModel>(), IViewUi {

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }
}