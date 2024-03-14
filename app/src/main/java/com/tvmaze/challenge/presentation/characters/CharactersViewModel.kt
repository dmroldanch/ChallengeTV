package com.tvmaze.challenge.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvmaze.challenge.core.di.IODispatcher
import com.tvmaze.challenge.core.di.MainDisplatcher
import com.tvmaze.challenge.domain.DomainResponse
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.domain.repository.ICharactersRepository
import com.tvmaze.challenge.domain.repository.IEpisodesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: ICharactersRepository,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    @MainDisplatcher private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _list = mutableStateListOf<Character>()
    val list: SnapshotStateList<Character> get() = _list

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
            when (val result = repository.getCharacters()) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {
                        _list.clear()
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
            when (val result = repository.getCharactersQuery(keyword)) {
                is DomainResponse.OnFailure -> {
                    withContext(mainDispatcher) {
                        _list.clear()
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