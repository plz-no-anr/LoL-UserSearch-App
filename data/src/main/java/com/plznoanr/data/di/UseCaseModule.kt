package com.plznoanr.data.di

import com.plznoanr.data.repository.AppRepositoryImpl
import com.plznoanr.domain.repository.AppRepository
import com.plznoanr.domain.usecase.key.TestUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object UseCaseModule {
//    @Provides
//    @Singleton
//    fun provideTestUseCase(repository: AppRepository,
//                           coroutineDispatcher: CoroutineDispatcher
//    ) = TestUseCase(repository,
//        coroutineDispatcher)
//}