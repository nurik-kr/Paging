package kg.nurik.pagination.common

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import kg.nurik.pagination.data.model.BasePagingModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseDataSource<T>(
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, T>() { // можем переиспользовать в другом списке

    private val limit = 20
    private val offset = 20
    abstract fun getListPageNumber(offset: Int, limit: Int): BasePagingModel<T>?

    class Factory<T, D : BaseDataSource<T>>(private val factory: () -> D) :
        DataSource.Factory<Int, T>() {
        private val dataSourceFactoryLiveData = MutableLiveData<BaseDataSource<T>>()
        override fun create() = factory().apply { dataSourceFactoryLiveData.postValue(this) }
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, T>
    ) {
        scope.launch(Dispatchers.IO) {
            runCatching {
                val result = getListPageNumber(
                    offset = 0,
                    limit = limit
                ) // указываем сколько он должен скачать первый раз
                result?.data?.let { callback.onResult(it, 0, 1) }// cкачал с 0 по 20шт
            }.onFailure {
                Log.d("_______Error", "ERROR")
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {
        runCatching {
            val result = getListPageNumber(
                offset = 20 * params.key,
                limit = limit
            ) // указываем сколько он должен скачать первый раз
            result?.data?.let { callback.onResult(it, params.key + 1) }//
        }.onFailure {
            Log.d("_______Error", "ERROR")
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, T>) {}
}