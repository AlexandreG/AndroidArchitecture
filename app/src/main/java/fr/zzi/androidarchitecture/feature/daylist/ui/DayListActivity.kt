package fr.zzi.androidarchitecture.feature.daylist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zzi.androidarchitecture.R

class DayListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_list)

        initFragment()
    }

    private fun initFragment() {
        val alreadyAddedFragment = supportFragmentManager.findFragmentByTag(DayListFragment.TAG)
        if (alreadyAddedFragment == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(
                    R.id.activity_day_list_layout,
                    DayListFragment.newInstance(),
                    DayListFragment.TAG
                )
                commit()
            }
        }
    }

}
