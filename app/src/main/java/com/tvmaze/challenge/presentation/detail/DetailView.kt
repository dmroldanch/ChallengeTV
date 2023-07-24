package com.tvmaze.challenge.presentation.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.presentation.componets.ImageLogo
import com.tvmaze.challenge.presentation.componets.MyCard
import com.tvmaze.challenge.presentation.componets.MyCardDetail
import com.tvmaze.challenge.presentation.componets.MyCardDetailLandScape
import com.tvmaze.challenge.presentation.componets.MyLazyRowTalents
import com.tvmaze.challenge.presentation.componets.TextWithTitle
import com.tvmaze.challenge.presentation.theme.PrimaryColor

@Composable
fun DetailView(
    id: Int,
    vm: DetailViewModel = hiltViewModel(),

    ) {

    LaunchedEffect(key1 = true) {
        vm.getTalentsList(id)
        vm.getShowDetails(id)
    }

    DetailBody(
        showDetail = vm.showDetail.value,
        talents = vm.listTalents
    )
}

@Composable
fun DetailBody(
    showDetail: Show,
    talents: List<Talents>
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

        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                LazyColumn(
                    state = state,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        ImageLogo()
                    }

                    item {
                        MyCardDetail(
                            showDetail,
                            0,
                            1,
                            state,
                            {}
                        )
                    }

                    item {
                        TextWithTitle(title = "Sinopsis", body = showDetail.synopsis)
                    }

                    item {
                        TextWithTitle(title = "Generos", body = showDetail.genres)
                    }

                    item {
                        TextWithTitle(
                            title = "Horarios",
                            body = "${showDetail.airtime} | ${showDetail.airdate} "
                        )
                    }

                    item {
                        MyLazyRowTalents(talents)
                    }
                }
            }

            else -> {
                MyCardDetailLandScape(
                    showDetail,
                    talents
                )
            }
        }


    }
}








