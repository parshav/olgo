package com.pv.olgo.announcements

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pv.base.BaseScreen
import com.pv.base.log
import com.pv.base.screen
import com.pv.firebase.RequestAnnouncements
import com.pv.olgo.R
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject

class AnnouncementsScreen : BaseScreen() {

    private val announcementsRequester: RequestAnnouncements by inject()
    private val announcementsAdapter: AnnouncementsAdapter by inject()

    private lateinit var recyclerView: RecyclerView

    override fun ui() = screen {
        layout = R.layout.screen_announcements
    }

    override fun onViewLoaded(view: View) {

        recyclerView = view.findViewById(R.id.recycler_view)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = announcementsAdapter
        }
    }

    override fun bindings(): Array<Disposable> = arrayOf(
        announcementsRequester.getAnnouncements().subscribe {
            it.fold(
                {
                    log("Error'd")
                },
                {
                    log("Got AnnouncementsWrapper ${it.announcements}")
                    announcementsAdapter.setData(it.announcements.toTypedArray())
                }
            )
        }
    )
}