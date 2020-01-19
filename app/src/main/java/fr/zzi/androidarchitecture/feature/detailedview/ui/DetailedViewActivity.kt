package fr.zzi.androidarchitecture.feature.detailedview.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zzi.androidarchitecture.R

class DetailedViewActivity : AppCompatActivity() {

    companion object {
        fun navigate(context: Context): Intent {
            return Intent(context, DetailedViewActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_day_item)

        //initFragment()
    }

    private fun initFragment() {
        /*    val alreadyAddedFragment = supportFragmentManager.findFragmentByTag(DayListFragment.TAG)
            if (alreadyAddedFragment == null) {
                supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.activity_day_list_layout,
                        DayListFragment.newInstance(),
                        DayListFragment.TAG
                    )
                    commit()
                }
            }*/
    }

}
