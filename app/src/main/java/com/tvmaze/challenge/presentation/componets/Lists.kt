package com.tvmaze.challenge.presentation.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.tvmaze.challenge.domain.model.show.Talents


@Composable
fun MyLazyRowTalents(series: List<Talents>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth().padding(top = 8.dp)
            .height(150.dp)
    ) {
        items(items = series, itemContent = { item ->
            Box(
                Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                Column(
                    modifier = Modifier
                        .size(150.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        painter = rememberAsyncImagePainter(item.image),
                        contentDescription = null,
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .fillMaxHeight(0.7F)
                    )
                    Text(
                        text = item.name,
                        modifier = Modifier.padding(4.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                    )
                }
            }
        })
    }
}