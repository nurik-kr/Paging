package kg.nurik.pagination.data.interactor

import kg.nurik.pagination.data.model.BasePagingModel
import kg.nurik.pagination.data.model.Data
import kg.nurik.pagination.data.remote.SharesService

interface PagingInteractor {
    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>
}


class PagingInteractorImpl(private val service: SharesService) : PagingInteractor {
    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return service.getShares(
            apiKey = "b8b0a9db5b82aba1e031bf7b99a90eb9",
            symbols = "AAPL",
            sort = "DESC",
            limit = limit,
            offset = offset
        )
    }
}