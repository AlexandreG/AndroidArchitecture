package fr.zzi.androidarchitecture.feature.teams.data

import fr.zzi.androidarchitecture.common.RestClient
import fr.zzi.androidarchitecture.feature.teams.domain.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

object TeamsDataSource {

    private val retrofitService: RetrofitService

    init {
        retrofitService = RestClient.createService(RetrofitService::class.java)
    }

    suspend fun searchTeams(
        keyword: String
    ): SearchResult {
        return retrofitService.searchTeam(
            keyword
        )
    }

    interface RetrofitService {

        @GET("1/searchteams.php")
        suspend fun searchTeam(
            @Query("t") keyword: String
        ): SearchResult

    }

}