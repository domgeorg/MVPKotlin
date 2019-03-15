package gr.mobile.mvp.kotlin.ui.fragment.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.mvp.presenter.empty.EmptyMvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.ui.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tab.*

class TabFragment : BaseFragment<EmptyMvpPresenter>(), MvpView {

    companion object {
        private const val ARG_TITLE = "arg_title"

        fun newInstance(title: String): TabFragment {
            val args = Bundle()
            args.putSerializable(ARG_TITLE, title)
            val fragment = TabFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var title: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPassData()
        initLayout()
    }

    private fun getPassData() {
        arguments?.let {
            title = it.getString(ARG_TITLE, "")
        }
    }

    private fun initLayout() {
        titleTextView.text = title
    }
}