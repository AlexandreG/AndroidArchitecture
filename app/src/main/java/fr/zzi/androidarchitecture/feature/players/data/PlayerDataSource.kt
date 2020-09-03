package fr.zzi.androidarchitecture.feature.players.data

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.players.domain.PlayersResult
import retrofit2.http.GET
import retrofit2.http.Query

object PlayerDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(RetrofitService::class.java)
    }

    suspend fun searchPlayers(
        team: String
    ): PlayersResult {
        return retrofitService.searchPlayers(
            team
        )
    }

    interface RetrofitService {

        @GET("${RestClient.API_KEY}/searchplayers.php")
        suspend fun searchPlayers(
            @Query("t") team: String
        ): PlayersResult

    }

}