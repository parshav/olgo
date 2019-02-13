package com.pv.base

import android.content.Context
import androidx.annotation.StringRes
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

interface ResourceHelper {

    fun getString(@StringRes stringID: Int): String
}

internal class ResourceHelperImpl(
    private val context: Context
) : ResourceHelper {

    override fun getString(@StringRes stringID: Int): String = context.resources.getString(stringID)
}

val resourceHelperModule = module {
    factory<ResourceHelper> { ResourceHelperImpl(androidContext()) }
}