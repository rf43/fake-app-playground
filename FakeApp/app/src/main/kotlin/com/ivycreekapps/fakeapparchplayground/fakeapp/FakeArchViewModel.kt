package com.ivycreekapps.fakeapparchplayground.fakeapp

import androidx.annotation.LayoutRes
import com.ivycreekapps.fakeapparchplayground.R
import com.ivycreekapps.fakeapparchplayground.kmvp.IViewModel

data class FakeArchViewModel(
    @LayoutRes val screenLayoutRes: Int = R.layout.fragment_fake_app_default
) : IViewModel