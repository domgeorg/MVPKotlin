package gr.mobile.mvp.kotlin.ui.activity.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.model.SpeakerEvent
import gr.mobile.mvp.kotlin.mvp.interactor.details.DetailsMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.details.DetailsMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.details.DetailsMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.details.DetailsMvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_speaker_details.*

class DetailsActivity : BaseActivity<DetailsMvpPresenter>(), DetailsMvpView{

    lateinit var speakerEvent : SpeakerEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPassData()
        setContentView(R.layout.activity_speaker_details)
        presenter = DetailsMvpPresenterImpl(this, DetailsMvpInteractorImpl())
        presenter?.getSpeakerEvent()
        initLayout()
    }

    fun initLayout() {

    }

    fun getPassData() {
        speakerEvent = intent.extras?.getParcelable("arg_speaker_event") as SpeakerEvent
    }

    override fun showSpeakerDetails(speakerEvent: SpeakerEvent) {
        nameTextView.text = speakerEvent.speaker.name
        titleTextView.text = speakerEvent.speaker.title
        descriptionTextView.text = speakerEvent.speaker.description
        Picasso.get().load(speakerEvent.photo).placeholder(R.mipmap.ic_launcher).into(speakerImageView)
        showData()
    }

}