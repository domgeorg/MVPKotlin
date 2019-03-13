package gr.mobile.mvp.kotlin.ui.adapter.list

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.Speaker

class ListRecyclerViewAdapter(private var speakersList: ArrayList<Speaker>) :
    RecyclerView.Adapter<ListRecyclerViewAdapter.SpeakerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_speaker, parent, false)
        return SpeakerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return speakersList.size
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        val speaker = speakersList[position]
        holder.nameTextView?.text = speaker.name
        holder.titleTextView?.text = speaker.title
        holder.descriptionTextView?.text = speaker.description
    }

    class SpeakerViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var nameTextView: AppCompatTextView? = null
        var titleTextView: AppCompatTextView? = null
        var descriptionTextView: AppCompatTextView? = null

        init {
            nameTextView = row.findViewById(R.id.nameTextView)
            titleTextView = row.findViewById(R.id.titleTextView)
            descriptionTextView = row.findViewById(R.id.descriptionTextView)
        }
    }
}
