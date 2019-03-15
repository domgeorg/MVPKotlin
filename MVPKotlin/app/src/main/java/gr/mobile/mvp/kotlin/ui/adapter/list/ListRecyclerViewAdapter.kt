package gr.mobile.mvp.kotlin.ui.adapter.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.Speaker
import kotlinx.android.synthetic.main.row_speaker.view.*


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

    class SpeakerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(speaker: Speaker, listener: (Speaker) -> Unit) {
            itemView.nameTextView.text = speaker.name
            itemView.titleTextView.text = speaker.title
            itemView.descriptionTextView.text = speaker.description
            itemView.setOnClickListener { listener(speaker) }
        }
    }
}
