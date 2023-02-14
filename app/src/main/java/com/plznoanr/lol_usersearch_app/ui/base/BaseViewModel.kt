package com.plznoanr.lol_usersearch_app.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

data class UiState<T>(
    val isLoading: Boolean = false,
    val data: T?,
    val isError: Boolean = false,
    val errorMessage: String = "",
): ViewState

interface ViewState // 현재 뷰가 보여지는 상태

interface ViewEvent // 사용자가 뷰에서 발생시키는 이벤트

interface ViewSideEffect // 뷰에 보여지는 이펙트

abstract class BaseViewModel<UiState: ViewState, Event: ViewEvent, Effect: ViewSideEffect>: ViewModel() {

    abstract fun setInitialState(): UiState

    abstract fun handleEvent(event: Event)

    private val initialState: UiState by lazy { setInitialState() }

    private val _viewState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
    val viewState: StateFlow<UiState> = _viewState

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscriptToEvents()
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = _viewState.value.reducer()
        _viewState.value = newState
    }

    private fun subscriptToEvents() {
        viewModelScope.launch {
            _event.collect { event ->
                handleEvent(event)
            }
        }
    }

    fun setEvent(event: Event) { // 뷰에서 받는 이벤트 처리
        viewModelScope.launch {
            _event.emit(event)
        }
    }

    protected fun setEffect(builder: () -> Effect) { // 뷰에 보여질 이펙트
        val effect = builder()
        viewModelScope.launch {
            _effect.send(effect)
        }
    }

}