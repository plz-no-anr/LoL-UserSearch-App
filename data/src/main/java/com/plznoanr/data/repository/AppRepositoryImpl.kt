package com.plznoanr.data.repository

import com.plznoanr.data.repository.local.LocalDataSource
import com.plznoanr.data.repository.remote.RemoteDataSource
import com.plznoanr.data.repository.local.PreferenceDataSource
import com.plznoanr.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val preferenceDataSource: PreferenceDataSource
) : AppRepository {
    override var apiKey: String
        get() = preferenceDataSource.apiKey
        set(value) {
            preferenceDataSource.apiKey = value
        }


}