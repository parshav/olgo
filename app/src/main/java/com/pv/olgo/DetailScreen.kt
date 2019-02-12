package com.pv.olgo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.pv.base.BaseScreen
import com.pv.base.screen
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module.module

class DetailScreen : BaseScreen() {

    private lateinit var title: TextView
    private lateinit var desc: TextView

    private val viewModel: DetailScreenViewModel by inject {
        parametersOf(
            arguments?.getString(titleKey),
            arguments?.getString(descKey)
        )
    }

    override fun ui() = screen {
        layout = R.layout.screen_detail
    }

    override fun onViewLoaded(view: View) {
        title = view.findViewById(R.id.tv_title)
        desc = view.findViewById(R.id.tv_desc)
    }

    override fun bindings(): Array<Disposable> = arrayOf(
        viewModel.title().subscribe(title::setText),
        viewModel.desc().subscribe(desc::setText)
    )

    companion object {

        private const val titleKey = "titleKey"
        private const val descKey = "descKey"

        fun new(title: String?, desc: String?): DetailScreen {
            return DetailScreen().apply {
                arguments = Bundle().apply {
                    putString(titleKey, title)
                    putString(descKey, desc)
                }
            }
        }
    }
}

val detailScreenModule = module {

    factory { (title: String, desc: String) -> DetailScreenViewModel(title, desc) }
}