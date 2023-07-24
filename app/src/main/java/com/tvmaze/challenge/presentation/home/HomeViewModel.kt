package com.tvmaze.challenge.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvmaze.challenge.core.di.IODispatcher
import com.tvmaze.challenge.core.di.MainDisplatcher
import com.tvmaze.challenge.core.utils.getDateFromToday
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TVShowsRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDisplatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _list = mutableStateListOf<Show>()
    val list: SnapshotStateList<Show> get() = _list

    private val _search = mutableStateOf("")
    val search: State<String?> get() = _search

    init {
        getHeroesList()
    }

    fun updateSearchText(text: CharSequence?) {
        _search.value = text.toString()
    }

    fun getHeroesList() {

        viewModelScope.launch(ioDispatcher) {
            when (val result = repository.getschedules("US", getDateFromToday())) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {

                    }
                }

                is DomainResponse.Success -> {
                    withContext(mainDispatcher) {
                        _list.clear()
                        _list.addAll(result.data)

                    }
                }
            }
        }
    }


    fun getShowByQuery() {
        var keyword = "A"
        if (search.value?.isEmpty() == false) {
            keyword = search.value.toString()
        }

        viewModelScope.launch(ioDispatcher) {
            when (val result = repository.getschedulesByQuery(keyword, "US", getDateFromToday())) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {

                    }
                }

                is DomainResponse.Success -> {
                    withContext(mainDispatcher) {
                        _list.clear()
                        _list.addAll(result.data)

                    }
                }
            }
        }
    }
}