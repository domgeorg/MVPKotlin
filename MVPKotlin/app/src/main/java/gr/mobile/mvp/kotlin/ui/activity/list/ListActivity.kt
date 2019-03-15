package gr.mobile.mvp.kotlin.ui.activity.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.Speaker
import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.interactor.list.ListMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.list.ListMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.list.ListMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.list.ListMvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import gr.mobile.mvp.kotlin.ui.activity.details.DetailsActivity
import gr.mobile.mvp.kotlin.ui.adapter.list.ListRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : BaseActivity<ListMvpPresenter>(), ListMvpView {

    val imageUrl : String = "https://picsum.photos/200/300/?random"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        presenter = ListMvpPresenterImpl(this, ListMvpInteractorImpl())
        presenter?.getSpeakers()
        initLayout()
    }

    private fun initLayout() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun showSpeaker(speakers: ArrayList<Speaker>) {
        recyclerView.adapter = ListRecyclerViewAdapter(speakers) { speaker : Speaker -> speakerClicked(speaker)}
        showData()
    }

    private fun speakerClicked(speaker: Speaker) {
        val intent = Intent(this@ListActivity, DetailsActivity::class.java)
        val speakerEvent = SpeakerEvent(speaker, imageUrl)
        intent.putExtra("arg_speaker_event", speakerEvent)
        startActivity(intent)
    }
}
