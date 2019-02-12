package com.pv.firebase

import android.util.Log
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.jakewharton.rxrelay2.BehaviorRelay
import com.pv.firebase.models.AnnouncementsWrapper
import io.reactivex.Observable
import org.koin.dsl.module.module

interface RequestAnnouncements {
    fun getAnnouncements(): Observable<AnnouncementsResponse>
}

typealias AnnouncementsResponse = Either<Error, AnnouncementsWrapper>

internal class RequestAnnouncementsImpl(
    private val firebaseHolder: FirebaseHolder
) : RequestAnnouncements {

    private var data: AnnouncementsResponse? = null

    override fun getAnnouncements(): Observable<AnnouncementsResponse> {

        val obs: BehaviorRelay<AnnouncementsResponse> = BehaviorRelay.create()

        data?.let {
            Log.d("PV", "This was cached")
            obs.accept(it)
        } ?: run {
            Log.d("PV", "This was NOT AT ALL cached")
            firebaseHolder.getDbRef(forChild = "data")
                .addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onCancelled(p0: DatabaseError) {
                        obs.accept(Error("Database Error").left())
                    }

                    override fun onDataChange(ds: DataSnapshot) {
                        ds.getValue(AnnouncementsWrapper::class.java)?.let {
                            obs.accept(it.right())
                            data = it.right()
                        } ?: run {
                            obs.accept(Error("Parsing Error").left())
                        }
                    }

                })
        }
        return obs
    }
}

val announcementsRequestModule = module {
    scope("main_activity_scope") {
        RequestAnnouncementsImpl(get()) as RequestAnnouncements
    }
}