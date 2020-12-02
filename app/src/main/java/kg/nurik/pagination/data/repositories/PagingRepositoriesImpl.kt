package kg.nurik.pagination.data.repositories

import kg.nurik.pagination.data.interactor.PagingInteractor
import kg.nurik.pagination.data.model.BasePagingModel
import kg.nurik.pagination.data.model.Data

interface PagingRepositories {
    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>
}

class PagingRepositoriesImpl(private val network: PagingInteractor) : PagingRepositories {

    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return network.loadData(limit = limit, offset = offset)
    }
}