package fr.zzi.androidarchitecture.feature.players.ui

import android.util.Log
import fr.zzi.androidarchitecture.feature.players.data.PlayerRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class PlayersPresenter(
    val view: PlayersFragment,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    private var job: Job? = null

    init {
        view.presenter = this
    }

    fun start(team: String) {
        job?.cancel()
        job = launch(Dispatchers.IO) {
            try {
                val searchResult = PlayerRepository.findTeams(team)
                withContext(Dispatchers.Main) {
                    view.displayPlayers(searchResult.player)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Failed to search players", e)
            }
        }
    }

}