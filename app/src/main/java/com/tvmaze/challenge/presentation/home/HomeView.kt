package com.tvmaze.challenge.presentation.home

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tvmaze.challenge.R
import com.tvmaze.challenge.domain.model.episodes.Episode
import com.tvmaze.challenge.presentation.componets.GifImage
import com.tvmaze.challenge.presentation.componets.ImageLogo
import com.tvmaze.challenge.presentation.componets.ImageLogoFirst
import com.tvmaze.challenge.presentation.componets.MyCard
import com.tvmaze.challenge.presentation.theme.PrimaryColor


@Composable
fun HomeView(
    vm: HomeViewModel = hiltViewModel(),
    navigateToCharacters: () -> Unit,
    navigateToEpisodes: () -> Unit
) {
    HomeBody(
        navigateToCharacters = {
            navigateToCharacters()
        },
        navigateToEpisodes = {
            navigateToEpisodes()
        },
    )
}
@Composable
fun HomeBody(
    modifier: Modifier = Modifier,
    navigateToCharacters: () -> Unit,
    navigateToEpisodes: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = PrimaryColor
    )

    val buttonShape = RoundedCornerShape(8.dp)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ImageLogoFirst()
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { navigateToEpisodes() },
                shape = buttonShape,
                modifier = Modifier
                    .fillMaxWidth(0.6F)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Episodes",
                        style = MaterialTheme.typography.h5,
                    )
                }
            }
            Button(
                onClick = { navigateToCharacters() },
                shape = buttonShape,
                modifier = Modifier
                    .fillMaxWidth(0.6F)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Characters",
                        style = MaterialTheme.typography.h5,

                    )
                }
            }
        }
    }
}









