package com.pv.firebase

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jakewharton.rxrelay2.BehaviorRelay
import com.pv.base.models.Announcements
import io.reactivex.Observable
import org.koin.dsl.module.module


interface FirebaseHolder {
    fun getAnnouncements(): Observable<AnnouncementsResponse>
}

class FirebaseHolderImpl : FirebaseHolder {

    private val databaseRef by lazy { FirebaseDatabase.getInstance().reference.child("announcements") }

    override fun getAnnouncements(): Observable<AnnouncementsResponse> {

        val obs: BehaviorRelay<AnnouncementsResponse> = BehaviorRelay.create()

        databaseRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                obs.accept(Error("Database Error").left())
            }

            override fun onDataChange(ds: DataSnapshot) {
                ds.getValue(Announcements::class.java)?.let {
                    obs.accept(it.right())
                } ?: run {
                    obs.accept(Error("Parsing Error").left())
                }
            }

        })
        return obs
    }
}

val firebaseModule = module {
    single<FirebaseHolder> { FirebaseHolderImpl() }
}

typealias AnnouncementsResponse = Either<Error, Announcements>
