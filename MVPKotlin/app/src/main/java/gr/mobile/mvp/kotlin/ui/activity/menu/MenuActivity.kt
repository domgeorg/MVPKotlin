package gr.mobile.mvp.kotlin.ui.activity.menu

import android.content.Intent
import android.os.Bundle
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.mvp.interactor.empty.EmptyMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.menu.MenuMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.menu.MenuMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.menu.MenuMvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import gr.mobile.mvp.kotlin.ui.activity.list.ListActivity
import gr.mobile.mvp.kotlin.ui.activity.permission.PermissionActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : BaseActivity<MenuMvpPresenter>(), MenuMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        presenter = MenuMvpPresenterImpl(this, EmptyMvpInteractorImpl())
        initLayout()
    }

    fun initLayout() {
        listButton.setOnClickListener {
            presenter?.onListClicked()
        }

        permissionButton.setOnClickListener {
            presenter?.onPermissionClicked()
        }
    }

    override fun goToListScreen() {
        startActivity(Intent(this, ListActivity::class.java))
    }

    override fun goToPermissionScreen() {
        startActivity(Intent(this, PermissionActivity::class.java))
    }
}