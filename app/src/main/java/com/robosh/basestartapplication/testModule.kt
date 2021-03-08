package com.robosh.basestartapplication

import org.koin.dsl.module

val testModule = module {

    factory { HomePresenter() }
}