package com.example.encoratask.di

import com.example.encoratask.vm.BaseViewModel
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(viewModel: BaseViewModel)
}