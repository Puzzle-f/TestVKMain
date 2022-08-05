package com.example.testvk.di

import com.example.testvk.ViewModelMain
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val application = module{
viewModel{ViewModelMain()}


}