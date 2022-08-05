package com.example.testvk.Schedulers

import io.reactivex.rxjava3.core.Scheduler

interface ISchedulers {
    fun background(): Scheduler
    fun main(): Scheduler
}