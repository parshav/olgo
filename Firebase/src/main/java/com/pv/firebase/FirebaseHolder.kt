package com.pv.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.koin.dsl.module.module


interface FirebaseHolder {

    //    fun getAnnouncements(): Observable<AnnouncementsResponse>
    fun getDbRef(forChild: String): DatabaseReference
}

class FirebaseHolderImpl : FirebaseHolder {

    private val ref by lazy { FirebaseDatabase.getInstance().reference }

    override fun getDbRef(forChild: String): DatabaseReference = ref.child(forChild)
}

val firebaseModule = module {
    single<FirebaseHolder> { FirebaseHolderImpl() }
}


