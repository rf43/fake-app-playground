package com.ivycreekapps.fakeapparchplayground.fakeapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ivycreekapps.fakeapparchplayground.AppKmvpActivity
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.fakeapp.fakecats.ui.FakeCatsFragment
import com.ivycreekapps.fakeapparchplayground.fakeapp.fakelocations.ui.FakeLocationFragment
import com.ivycreekapps.fakeapparchplayground.fakeapp.fakenotes.ui.FakeNotesFragment
import com.ivycreekapps.fakeapparchplayground.kmvp.IBottomNavBarUi

class FakeArchActivity :
    AppKmvpActivity<FakeArchActivity, FakeArchPresenter, FakeArchViewModel>(), // MVP Architecture
    IBottomNavBarUi {

    override val layoutRes: Int
        get() = R.layout.activity_fake_arch

    // This will allow an extending class to override the value
    // while keeping a default value
    override val bottomNavViewId: Int
        get() = R.id.bottom_navigation

    private var fragmentContainer: FrameLayout? = null
    private var bottomNavBarView: BottomNavigationView? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentContainer = findViewById(R.id.fake_app_container)

        bottomNavBarView = findViewById(bottomNavViewId)
        bottomNavBarView?.setOnNavigationItemSelectedListener(this)

        // set the initial fragment
        presenter.setFragment(R.layout.fragment_fake_location)
    }

    override fun createPresenter(): FakeArchPresenter {
        return FakeArchPresenter(this)
    }

    override fun renderViewModel(viewModel: FakeArchViewModel) {
        Log.i("renderViewModel", "break...")
        val frag = getFragmentByLayout(viewModel.screenLayoutRes)
        supportFragmentManager.beginTransaction().replace(R.id.fake_app_container, frag).commit()
        Log.i("renderViewModel", "break...")
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.menu_fake_notes -> {
                presenter.setFragment(R.layout.fragment_fake_notes)
                true
            }
            R.id.menu_fake_cats -> {
                presenter.setFragment(R.layout.fragment_fake_cats)
                true
            }
            R.id.menu_fake_location -> {
                presenter.setFragment(R.layout.fragment_fake_location)
                true
            }
            else -> {
                presenter.setFragment(R.layout.fragment_fake_app_default)
                true
            }
        }
    }

    private fun getFragmentByLayout(@LayoutRes layoutRes: Int): Fragment {
        return when (layoutRes) {
            R.layout.fragment_fake_location -> {
                FakeLocationFragment()
            }
            R.layout.fragment_fake_cats -> {
                FakeCatsFragment()
            }
            R.layout.fragment_fake_notes -> {
                FakeNotesFragment()
            }
            else -> FakeArchFragment()
        }
    }
}