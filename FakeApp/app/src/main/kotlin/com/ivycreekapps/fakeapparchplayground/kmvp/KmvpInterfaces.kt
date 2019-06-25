package com.ivycreekapps.fakeapparchplayground.kmvp

import androidx.annotation.IdRes
import com.google.android.material.bottomnavigation.BottomNavigationView

interface IViewUi

interface IViewModel

// All presenters must have a viewmodel associated with them
interface IPresenter<
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TViewModel : IViewModel> {

    val presenterViewUi: TPresenterViewUi

    var backingViewModel: TViewModel?
    var viewModel: TViewModel
}

interface IPresenterViewUi<
        TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>,
        TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>,
        TViewModel : IViewModel> : IViewUi {

    var backingPresenter: TPresenter?
    val presenter: TPresenter

    fun createPresenter(): TPresenter
    fun renderViewModel(viewModel: TViewModel)
}

interface IPresenterActivity<TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>, TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>, TViewModel : IViewModel> :
    IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>

interface IPresenterFragment<TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>, TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>, TViewModel : IViewModel> :
    IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>

interface IPresenterView<TPresenterViewUi : IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>, TPresenter : IPresenter<TPresenter, TPresenterViewUi, TViewModel>, TViewModel : IViewModel> :
    IPresenterViewUi<TPresenterViewUi, TPresenter, TViewModel>

interface IBottomNavBarUi : BottomNavigationView.OnNavigationItemSelectedListener {
    @get:IdRes
    val bottomNavViewId: Int
}

interface IBottomNavBarItemScreen {
    @get:IdRes
    val selectedItemId: Int
}