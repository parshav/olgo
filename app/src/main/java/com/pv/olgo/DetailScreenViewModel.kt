package com.pv.olgo

import io.reactivex.Observable

class DetailScreenViewModel(
    private val title: String,
    private val desc: String
) {

    fun title(): Observable<String> = Observable.just(title)
    fun desc(): Observable<String> = Observable.just(desc)
}