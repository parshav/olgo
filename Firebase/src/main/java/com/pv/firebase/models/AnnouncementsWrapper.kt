package com.pv.firebase.models

data class AnnouncementsWrapper(val announcements: List<Announcement> = emptyList())
data class Announcement(val title: String = "", val desc: String = "")