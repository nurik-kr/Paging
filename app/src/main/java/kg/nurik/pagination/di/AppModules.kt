package kg.nurik.pagination.di

import kg.nurik.pagination.data.interactor.PagingInteractor
import kg.nurik.pagination.data.interactor.PagingInteractorImpl
import kg.nurik.pagination.data.remote.RetrofitBuilder
import kg.nurik.pagination.data.repositories.PagingRepositories
import kg.nurik.pagination.data.repositories.PagingRepositoriesImpl
import kg.nurik.pagination.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single<PagingRepositories> { PagingRepositoriesImpl(get()) }
}

val apiModule = module {
    single { RetrofitBuilder.buildRetrofit() }
    single<PagingInteractor> { PagingInteractorImpl(get()) }
}
val appModules = listOf(viewModelModule,apiModule,repositoryModule)