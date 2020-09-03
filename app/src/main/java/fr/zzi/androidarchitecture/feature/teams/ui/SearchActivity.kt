package fr.zzi.androidarchitecture.feature.teams.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zzi.androidarchitecture.R
import kotlinx.coroutines.Dispatchers

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_team)

        initFragment()

    }

    private fun initFragment() {
        var fragment = supportFragmentManager.findFragmentByTag(SearchTeamFragment.TAG)
        if (fragment == null) {
            fragment = SearchTeamFragment.newInstance()
            supportFragmentManager.beginTransaction().apply {
                replace(
                    R.id.activity_search_team_layout,
                    fragment,
                    SearchTeamFragment.TAG
                )
                commit()
            }
            SearchTeamPresenter(fragment, Dispatchers.Default)
        }
    }

}
