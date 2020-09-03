package fr.zzi.androidarchitecture.feature.teams.data

import fr.zzi.androidarchitecture.feature.teams.domain.SearchResult

object TeamsRepository {

    suspend fun findTeams(
        keyword: String
    ): SearchResult {
        return TeamsDataSource.searchTeams(keyword)
    }

}