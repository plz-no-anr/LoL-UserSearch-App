package com.plznoanr.data.repository.local

import com.plznoanr.data.db.AppDao
import javax.inject.Inject

interface LocalDataSource {
}

class LocalDataSourceImpl (
    private val dao: AppDao
) : LocalDataSource {

}