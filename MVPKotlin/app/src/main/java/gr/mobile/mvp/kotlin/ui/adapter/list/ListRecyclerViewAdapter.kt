package gr.mobile.mvp.kotlin.ui.adapter.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.Speaker
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_speaker_details.*


class ListRecyclerViewAdapter(private var speakersList: ArrayList<Speaker>, val listener: (Speaker) -> Unit) :
    RecyclerView.Adapter<ListRecyclerViewAdapter.SpeakerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return speakersList.size
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        holder.bind(speakersList[position], listener)
    }

    class SpeakerViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {
        fun bind(speaker: Speaker, listener: (Speaker) -> Unit) {
            nameTextView.text = speaker.name
            titleTextView.text = speaker.title
            descriptionTextView.text = speaker.description
            containerView.setOnClickListener { listener(speaker) }
        }
    }
}
