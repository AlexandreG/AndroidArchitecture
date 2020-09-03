package fr.zzi.androidarchitecture.feature.players.data

import fr.zzi.androidarchitecture.feature.players.domain.PlayersResult

object PlayerRepository {

    suspend fun findTeams(
        team: String
    ): PlayersResult {
        return PlayerDataSource.searchPlayers(team)
    }

}