package com.plznoanr.data.repository.remote

import com.plznoanr.data.api.UserSearchApi
import javax.inject.Inject

interface RemoteDataSource {

}

class RemoteDataSourceImpl (
    private val api: UserSearchApi
): RemoteDataSource {

}
