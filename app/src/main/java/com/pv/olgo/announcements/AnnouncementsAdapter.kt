package com.pv.olgo.announcements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pv.firebase.models.Announcement
import com.pv.olgo.R

internal class AnnouncementsAdapter : RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementsViewHolder>() {

    private var data: Array<Announcement>? = null

    fun setData(announcements: Array<Announcement>) {
        this.data = announcements
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_announcement, parent, false)
        return AnnouncementsViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AnnouncementsViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class AnnouncementsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title by lazy { itemView.findViewById<TextView>(R.id.tv_title) }
        private val desc by lazy { itemView.findViewById<TextView>(R.id.tv_desc) }

        fun bind(position: Int) {
            title.text = data?.get(position)?.title
            desc.text = data?.get(position)?.desc
        }
    }
}