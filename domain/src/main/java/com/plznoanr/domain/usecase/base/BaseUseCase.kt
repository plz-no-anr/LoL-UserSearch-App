package com.plznoanr.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<in P, R> constructor(
    private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(parameter: P) : Flow<Result<R>> =
        execute(parameter)
            .catch { e ->
                e.printStackTrace()
                emit(Result.failure(e))
            }.flowOn(coroutineDispatcher)

    abstract fun execute(parameter: P) : Flow<Result<R>>
}