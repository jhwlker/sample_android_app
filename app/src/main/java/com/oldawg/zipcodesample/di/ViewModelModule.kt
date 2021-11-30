package com.oldawg.zipcodesample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oldawg.zipcodesample.viewmodels.ZipCodesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ZipCodesViewModel::class)
    abstract fun bindZipCodeViewModel(viewModel: ZipCodesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}