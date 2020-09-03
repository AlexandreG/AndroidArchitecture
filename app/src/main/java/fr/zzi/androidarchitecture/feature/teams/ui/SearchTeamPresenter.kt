package fr.zzi.androidarchitecture.feature.teams.ui

import android.util.Log
import fr.zzi.androidarchitecture.feature.teams.data.TeamsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SearchTeamPresenter(
    val view: SearchTeamFragment,
    override val coroutineContext: CoroutineContext
) : CoroutineScope {

    private var job: Job? = null

    init {
        view.presenter = this
    }

    fun onTextSearched(newInput: String) {
        job?.cancel()
        job = launch(Dispatchers.IO) {
            try {
                val searchResult = TeamsRepository.findTeams(newInput)
                withContext(Dispatchers.Main) {
                    view.displayTeams(searchResult.teams)
                }
            } catch (e: Exception) {
                Log.e("TAG", "Failed to search team", e)
            }
        }
    }

}