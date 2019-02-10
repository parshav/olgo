package com.pv.base.models

data class Announcements(val array: Array<Announcement>)
data class Announcement(val title: String, val desc: String)