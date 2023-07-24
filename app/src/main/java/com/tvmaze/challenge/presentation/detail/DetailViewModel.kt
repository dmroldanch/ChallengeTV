package com.tvmaze.challenge.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvmaze.challenge.core.di.IODispatcher
import com.tvmaze.challenge.core.di.MainDisplatcher
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.domain.repository.TVShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TVShowsRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDisplatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _showDetail = mutableStateOf(Show())
    val showDetail: State<Show> get() = _showDetail

    private val _listTalents = mutableStateListOf<Talents>()
    val listTalents: SnapshotStateList<Talents> get() = _listTalents


    fun getShowDetails(id: Int) {
        viewModelScope.launch(ioDispatcher) {
            when (val result = repository.getShowDetails(id)) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {

                    }
                }
                is DomainResponse.Success -> {
                    withContext(mainDispatcher) {
                        _showDetail.value = result.data
                    }
                }
            }
        }
    }

    fun getTalentsList(id: Int) {
        viewModelScope.launch(ioDispatcher) {
            when (val result = repository.getShowTalens(id)) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {

                    }
                }
                is DomainResponse.Success -> {
                    withContext(mainDispatcher) {
                        _listTalents.clear()
                        _listTalents.addAll(result.data)
                    }
                }
            }
        }
    }


}