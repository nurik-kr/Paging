package kg.nurik.pagination.data.remote

import kg.nurik.pagination.data.model.BasePagingModel
import kg.nurik.pagination.data.model.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface SharesService {

    @GET("eod")
    suspend fun getShares( //suspend потомучто корутины
        @Query("access_key") apiKey: String,
        @Query("symbols") symbols: String,
        @Query("sort") sort: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BasePagingModel<Data>
}