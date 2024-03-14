package com.tvmaze.challenge.presentation.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tvmaze.challenge.R
import com.tvmaze.challenge.domain.model.character.Character
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.presentation.componets.GifImage
import com.tvmaze.challenge.presentation.componets.ImageLogo
import com.tvmaze.challenge.presentation.componets.MyCard
import com.tvmaze.challenge.presentation.componets.MyCardCharacter
import com.tvmaze.challenge.presentation.theme.PrimaryColor


@Composable
fun CharactersView(
    vm: CharactersViewModel = hiltViewModel(),
    onItemClick: (id: Int) -> Unit
) {
    CharactersBody(
        list = vm.list, viewModel = vm,
        onItemClick = {
            onItemClick(it)
        },
    )
}

@Composable
fun CharactersBody(
    modifier: Modifier = Modifier,
    list: List<Character> = emptyList(),
    viewModel: CharactersViewModel,
    onItemClick: (Int) -> Unit,
) {

    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = PrimaryColor
    )

    val state = rememberLazyListState()
    val configuration = LocalConfiguration.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var search by remember { mutableStateOf(false) }

        Column {
            ImageLogo()
            Row {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.8F)
                        .padding(top = 12.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
                        .clip(RoundedCornerShape(18.dp)),
                    value = viewModel.search.value.toString(),
                    onValueChange = { text ->
                        viewModel.updateSearchText(text)
                    },
                    placeholder = { Text(text = stringResource(R.string.hint_search_query)) },
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.subtitle1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        if (!search) {
                            Icons.Filled.Search
                        } else {
                            Icons.Filled.Close
                        },
                        stringResource(R.string.Details),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clickable {
                                if (!search) {
                                    viewModel.getShowByQuery()
                                } else {
                                    viewModel.getHeroesList()
                                    viewModel.updateSearchText("")
                                }
                                search = !search
                            },
                    )
                }


            }

            if (list.isEmpty()) {
                GifImage()
            } else {
                LazyColumn(modifier = modifier) {
                    itemsIndexed(list) { index, item ->
                        MyCardCharacter(
                            item,
                            index,
                            1,
                            state,
                            onItemClick
                        )
                    }
                }
            }
        }
    }
}








