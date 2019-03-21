package gr.mobile.mvp.kotlin.ui.activity.menu

import android.content.Intent
import android.os.Bundle
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.mvp.interactor.menu.MenuMvpInteractorImpl
import gr.mobile.mvp.kotlin.mvp.presenter.menu.MenuMvpPresenter
import gr.mobile.mvp.kotlin.mvp.presenter.menu.MenuMvpPresenterImpl
import gr.mobile.mvp.kotlin.mvp.view.menu.MenuMvpView
import gr.mobile.mvp.kotlin.network.client.Client
import gr.mobile.mvp.kotlin.network.parser.response.categories.CategoriesResponse
import gr.mobile.mvp.kotlin.ui.activity.articles.ArticlesActivity
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import gr.mobile.mvp.kotlin.ui.activity.fragment.FragmentActivity
import gr.mobile.mvp.kotlin.ui.activity.permission.PermissionActivity
import kotlinx.android.synthetic.main.activity_menu.*
import timber.log.Timber

class MenuActivity : BaseActivity<MenuMvpPresenter>(), MenuMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        presenter = MenuMvpPresenterImpl(this, MenuMvpInteractorImpl(Client().createApi()))
        initLayout()
    }

    fun initLayout() {
        listButton.setOnClickListener {
            presenter?.onListClicked()
        }

        permissionButton.setOnClickListener {
            presenter?.onPermissionClicked()
        }

        fragmentButton.setOnClickListener {
            presenter?.onFragmentClicked()
        }

        testRequest.setOnClickListener {
            presenter?.getCategories()
        }
    }

    override fun goToListScreen() {
        startActivityModal(Intent(this, ArticlesActivity::class.java))
    }

    override fun goToPermissionScreen() {
        startActivity(Intent(this, PermissionActivity::class.java))
    }

    override fun goToFragmentScreen() {
        startActivity(Intent(this, FragmentActivity::class.java))
    }

    override fun showCategories(categories: CategoriesResponse) {
        Timber.d("Number of Categories = %s", categories.categories.size)
    }
}