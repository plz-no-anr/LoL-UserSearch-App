package com.plznoanr.lol_usersearch_app.ui.search

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.plznoanr.domain.model.Search
import com.plznoanr.domain.usecase.key.GetKeyUseCase
import com.plznoanr.domain.usecase.search.DeleteAllSearchUseCase
import com.plznoanr.domain.usecase.search.DeleteSearchUseCase
import com.plznoanr.domain.usecase.search.GetSearchUseCase
import com.plznoanr.domain.usecase.search.InsertSearchUseCase
import com.plznoanr.lol_usersearch_app.ui.base.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

sealed class SearchEvent : ViewEvent {
    object Refresh : SearchEvent()
}

sealed class SearchEffect : ViewSideEffect {
    sealed class Save: SearchEffect() {
        object Success : Save()
        data class Failed(val errMsg: String?) : Save()
    }
    sealed class Delete: SearchEffect() {
        object Success : Delete()
        data class Failed(val errMsg: String?) : Delete()
    }
}

@HiltViewModel
class SearchViewModel @Inject constructor(
    keyUseCase: GetKeyUseCase,
    private val getSearchUseCase: GetSearchUseCase,
    private val insertSearchUseCase: InsertSearchUseCase,
    private val deleteSearchUseCase: DeleteSearchUseCase,
    private val deleteSearchAllUseCase: DeleteAllSearchUseCase
): BaseViewModel<UiState<List<Search>>, SearchEvent, SearchEffect>() {

    init {
        getSearch()
    }

    override fun setInitialState(): UiState<List<Search>> = UiState(
        data = null,
        isLoading = true,
        isError = false,
    )

    override fun handleEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.Refresh -> {
                getSearch()
            }
        }
    }

    private fun getSearch() {
        viewModelScope.launch(Dispatchers.IO) {
            setState { copy(isLoading = true, isError = false) }
            getSearchUseCase(Unit).collectLatest {
                it.onSuccess {
                    setState { copy(data = it, isLoading = false, isError = false) }
                }
                it.onFailure {
                    setState { copy(data = null, isLoading = false, isError = true) }
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun insertSearch(name: String) {
        if (!validateName(name)) {
            setEffect { SearchEffect.Save.Failed("emptyPassword") }
            return
        }
        val search = Search(
            name = name,
            date = LocalDate.now().toString()
        )
        viewModelScope.launch(Dispatchers.IO) {
            insertSearchUseCase(search).collectLatest {
                it.onSuccess {
                    setEffect { SearchEffect.Save.Success }
                }
                it.onFailure {
                    setEffect { SearchEffect.Save.Failed(null) }
                }
            }
        }
    }

    fun deleteSearch(uid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteSearchUseCase(uid).collectLatest {
                it.onSuccess {
                    setEffect { SearchEffect.Delete.Success }
                }
                it.onFailure {
                    setEffect { SearchEffect.Delete.Failed(null) }
                }
            }
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteSearchAllUseCase(Unit).collectLatest {
                it.onSuccess {
                    setEffect { SearchEffect.Delete.Success }
                }
                it.onFailure {
                    setEffect { SearchEffect.Delete.Failed(null) }
                }
            }
        }
    }

    private fun validateName(name: String?): Boolean = !name.isNullOrEmpty()


}