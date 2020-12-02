package kg.nurik.pagination.ui.main

import androidx.lifecycle.viewModelScope
import kg.nurik.pagination.common.BaseDataSource
import kg.nurik.pagination.common.BasePagingViewModel
import kg.nurik.pagination.data.model.BasePagingModel
import kg.nurik.pagination.data.model.Data
import kg.nurik.pagination.data.repositories.PagingRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

class MainViewModel(private val service: PagingRepositories) :
    BasePagingViewModel<Data, MainViewModel.MainDataSource>() {

    override val sourceFactory by lazy {
        BaseDataSource.Factory {
            MainDataSource(viewModelScope)
        }
    }

    val data = getPagedList()

    inner class MainDataSource(scope: CoroutineScope) : BaseDataSource<Data>(scope) {
        //внутрений класс и тут мы отдаем свою модельку
        override fun getListPageNumber(offset: Int,limit: Int): BasePagingModel<Data>? {
            return runBlocking {
                return@runBlocking service.loadData(offset = offset, limit = limit)

            }// пока этот код не выполниться , главный метод не сработает
        }

    }

}