package com.oldawg.zipcodesample.di

import com.oldawg.zipcodesample.ui.EntryFragment
import com.oldawg.zipcodesample.ui.ResultsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeEntryFragment(): EntryFragment

    @ContributesAndroidInjector
    abstract fun contributeResultsFragment(): ResultsFragment
}