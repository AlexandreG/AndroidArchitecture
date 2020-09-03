package fr.zzi.androidarchitecture.feature.players.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.zzi.androidarchitecture.R
import kotlinx.coroutines.Dispatchers

class PlayersActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TEAM_NAME = "team_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        val teamName = intent.extras?.getString(EXTRA_TEAM_NAME)

        title = teamName
        initFragment(teamName ?: "")

    }

    private fun initFragment(teamName: String) {
        var fragment = supportFragmentManager.findFragmentByTag(PlayersFragment.TAG)
        if (fragment == null) {
            fragment = PlayersFragment.newInstance(teamName)
            supportFragmentManager.beginTransaction().apply {
                replace(
                    R.id.activity_players_layout,
                    fragment,
                    PlayersFragment.TAG
                )
                commit()
            }
            PlayersPresenter(fragment, Dispatchers.Default)
        }
    }

}
