package kg.nurik.pagination.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

abstract class BasePagingViewModel<T, D : BaseDataSource<T>> :
    ViewModel() { //можем переиспользовать

    abstract val sourceFactory: BaseDataSource.Factory<T, D>

    fun getPagedList(): LiveData<PagedList<T>> // cвой лист для пагинации return списки для RecyclerView
    {
        return LivePagedListBuilder(
            sourceFactory, // экземпрляр класс нашего DataSource
            PagedList.Config.Builder()
                .setPageSize(20)//обязательная часть!!!
                .build()
        ).build()
    }

}