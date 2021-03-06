package com.pv.olgo.announcements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.pv.base.NavigationType
import com.pv.base.NavigatorTemplate
import com.pv.firebase.models.Announcement
import com.pv.olgo.DetailScreen
import com.pv.olgo.R
import org.koin.dsl.module.module
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

internal class AnnouncementsAdapter : RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementsViewHolder>(),
    KoinComponent {

    private var data: Array<Announcement>? = null
    private val navigatorTemplate: NavigatorTemplate by inject()

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
        private val card by lazy { itemView.findViewById<CardView>(R.id.cv_main) }

        fun bind(position: Int) {
            val titleData = data?.get(position)?.title
            val descData = data?.get(position)?.desc

            title.text = titleData
            desc.text = descData
            card.setOnClickListener {
                navigatorTemplate.navigateTo(DetailScreen.new(titleData, descData), type = NavigationType.Modal)
            }
        }
    }
}

val announcementsAdapterModule = module {
    factory { AnnouncementsAdapter() }
}