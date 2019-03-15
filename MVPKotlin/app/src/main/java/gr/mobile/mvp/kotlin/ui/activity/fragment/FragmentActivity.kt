package gr.mobile.mvp.kotlin.ui.activity.fragment

import android.os.Bundle
import gr.mobile.mvp.kotlin.R
import gr.mobile.mvp.kotlin.mvp.presenter.empty.EmptyMvpPresenter
import gr.mobile.mvp.kotlin.mvp.view.base.MvpView
import gr.mobile.mvp.kotlin.ui.activity.base.BaseActivity
import gr.mobile.mvp.kotlin.ui.fragment.tab.TabFragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : BaseActivity<EmptyMvpPresenter>(), MvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initLayout()
    }

    private val firstFragment: TabFragment = TabFragment.newInstance("First Fragment")
    private val secondFragment: TabFragment = TabFragment.newInstance("Second Fragment")
    private val thirdFragment: TabFragment = TabFragment.newInstance("Third Fragment")

    private fun initLayout() {
        fragmentManagerDelegate.showOrAddFragment(
            firstFragment,
            fragmentsToHide = *arrayOf(secondFragment, thirdFragment)
        )

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_item1 -> {
                    fragmentManagerDelegate.showOrAddFragment(firstFragment, fragmentsToHide = *arrayOf(secondFragment, thirdFragment))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_item2 -> {
                    fragmentManagerDelegate.showOrAddFragment(secondFragment, fragmentsToHide = *arrayOf(firstFragment, thirdFragment))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.action_item3 -> {
                    fragmentManagerDelegate.showOrAddFragment(thirdFragment, fragmentsToHide = *arrayOf(firstFragment, secondFragment))
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}