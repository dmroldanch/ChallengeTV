package com.tvmaze.challenge.presentation.componets

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.tvmaze.challenge.core.utils.animation.RotationArgs
import com.tvmaze.challenge.core.utils.animation.ScaleAndAlphaArgs
import com.tvmaze.challenge.core.utils.animation.StateAnimation
import com.tvmaze.challenge.domain.model.show.Show
import com.tvmaze.challenge.domain.model.show.Talents
import com.tvmaze.challenge.presentation.theme.PrimaryColor


@Composable
fun MyCard(
    show: Show,
    index: Int = 0,
    columns: Int,
    state: LazyListState,
    onClick: (Int) -> Unit
) {

    //Animation Card
    val (delay, easing) = state.calculateDelayAndEasing(index, columns)
    val animation = tween<Float>(durationMillis = 500, delayMillis = delay, easing = easing)
    val args = ScaleAndAlphaArgs(fromScale = 10f, toScale = 1f, fromAlpha = 0f, toAlpha = 1f)
    val (scale, alpha) = scaleAndAlpha(args = args, animation = animation)

    val argsRotation = RotationArgs(fromRotation = 80f, toRotation = 0f)
    val animationRotate = tween<Float>(durationMillis = 1300, delayMillis = delay, easing = easing)
    val rotation = rotation(argsRotation, animationRotate)

    val animationText = tween<Float>(durationMillis = 500, delayMillis = delay, easing = easing)
    val argsText = ScaleAndAlphaArgs(fromScale = 400f, toScale = 1f, fromAlpha = 0f, toAlpha = 1f)
    val (scaleText, alphaText) = scaleAndAlpha(args = argsText, animation = animationText)


    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(200.dp)
            //.graphicsLayer(alpha = alpha, scaleX = scale, scaleY = scale)
            .graphicsLayer(
                alpha = alpha,
                scaleX = scale,
                scaleY = scale,
                rotationX = rotation,
            )
            .animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing,

                    )
            )
            .clickable {
                onClick(show.id)
            },
    ) {
        Box {

            Row {
                Image(
                    painter = rememberAsyncImagePainter(show.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .height(200.dp)
                        .fillMaxWidth(0.4F)
                        .padding(end = 8.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .zIndex(2.0F)
                        .animateContentSize(
                            animationSpec = TweenSpec(
                                durationMillis = 600,
                                easing = LinearOutSlowInEasing,
                            )
                        )
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colors.surface.copy(alpha = 0.7F),
                                    MaterialTheme.colors.surface,
                                )
                            )
                        )
                        .zIndex(1.0F)
                        .fillMaxHeight()
                        .fillMaxWidth()

                ) {

                    Text(
                        text = show.name,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 10.dp, end = 8.dp)
                            .graphicsLayer(cameraDistance = scaleText)
                            .animateContentSize(
                                animationSpec = TweenSpec(
                                    durationMillis = 500,
                                    easing = LinearOutSlowInEasing,

                                    )
                            )
                            .background(Color.Transparent),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Box(Modifier.padding(start = 8.dp)) {
                        Divider(
                            Modifier
                                .height(4.dp)
                                .width(40.dp)
                                .background(PrimaryColor)
                                .padding(start = 12.dp, top = 8.dp)
                        )
                    }

                    Text(
                        text = show.network,
                        modifier = Modifier.padding(top = 12.dp, start = 8.dp),
                        fontSize = 15.sp
                    )

                    Text(
                        text = "${show.airdate} | ${show.airtime} ",
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 8.dp,
                            bottom = 16.dp
                        ),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Composable
fun MyCardDetail(
    show: Show,
    index: Int = 0,
    columns: Int,
    state: LazyListState,
    onClick: (Int) -> Unit
) {

    val context = LocalContext.current

    //Animation Card
    val (delay, easing) = state.calculateDelayAndEasing(index, columns)
    val animation = tween<Float>(durationMillis = 500, delayMillis = delay, easing = easing)
    val args = ScaleAndAlphaArgs(fromScale = 10f, toScale = 1f, fromAlpha = 0f, toAlpha = 1f)
    val (scale, alpha) = scaleAndAlpha(args = args, animation = animation)

    val argsRotation = RotationArgs(fromRotation = 80f, toRotation = 0f)
    val animationRotate = tween<Float>(durationMillis = 1300, delayMillis = delay, easing = easing)
    val rotation = rotation(argsRotation, animationRotate)

    val animationText = tween<Float>(durationMillis = 500, delayMillis = delay, easing = easing)
    val argsText = ScaleAndAlphaArgs(fromScale = 400f, toScale = 1f, fromAlpha = 0f, toAlpha = 1f)
    val (scaleText, alphaText) = scaleAndAlpha(args = argsText, animation = animationText)


    Card(
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(200.dp)
            .graphicsLayer(
                alpha = alpha,
                scaleX = scale,
                scaleY = scale,
                rotationX = rotation,
            )
            .animateContentSize(
                animationSpec = TweenSpec(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing,

                    )
            )
            .clickable {
                onClick(show.id)
            },
    ) {
        Box {

            Row {
                Image(
                    painter = rememberAsyncImagePainter(show.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(18.dp))
                        .height(200.dp)
                        .fillMaxWidth(0.4F)
                        .padding(end = 8.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .zIndex(2.0F)
                        .animateContentSize(
                            animationSpec = TweenSpec(
                                durationMillis = 600,
                                easing = LinearOutSlowInEasing,
                            )
                        )
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    MaterialTheme.colors.surface.copy(alpha = 0.7F),
                                    MaterialTheme.colors.surface,
                                )
                            )
                        )
                        .zIndex(1.0F)
                        .fillMaxHeight()
                        .fillMaxWidth()

                ) {

                    Text(
                        text = show.name,
                        modifier = Modifier
                            .padding(start = 8.dp, bottom = 10.dp, end = 8.dp)
                            .graphicsLayer(cameraDistance = scaleText)
                            .animateContentSize(
                                animationSpec = TweenSpec(
                                    durationMillis = 500,
                                    easing = LinearOutSlowInEasing,

                                    )
                            )
                            .background(Color.Transparent),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Box(Modifier.padding(start = 8.dp)) {
                        Divider(
                            Modifier
                                .height(4.dp)
                                .width(40.dp)
                                .background(PrimaryColor)
                                .padding(start = 12.dp, top = 8.dp)
                        )
                    }

                    Text(
                        text = show.network,
                        modifier = Modifier.padding(top = 12.dp, start = 8.dp),
                        fontSize = 15.sp
                    )

                    Text(
                        text = "Rating : ${show.rating}",
                        modifier = Modifier.padding(
                            start = 8.dp,
                            top = 8.dp,
                            end = 8.dp,
                            bottom = 16.dp
                        ),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Button(
                        modifier = Modifier.padding(8.dp),
                        onClick = {

                            val webIntent: Intent =  Uri.parse(show.linkSite).let { webpage ->
                                Intent(Intent.ACTION_VIEW, webpage)
                            }
                            context.startActivity(webIntent)
                        }
                    ) {
                        Text(text = "Visit Site")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCardDetailLandScape(
    show: Show,
    talents: List<Talents>
) {
    val context = LocalContext.current


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {

            Card(
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .fillMaxHeight()
                    .animateContentSize(
                        animationSpec = TweenSpec(
                            durationMillis = 500,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    .clickable {

                    },
            ) {
                Box {
                    Row {
                        // Image and details column
                        Column(
                            modifier = Modifier.weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(show.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(18.dp))
                                    .aspectRatio(0.7f)
                            )
                            TextWithTitle(title = "Generos", body = show.genres)
                            TextWithTitle(
                                title = "Horarios",
                                body = "${show.airtime} | ${show.airdate}"
                            )
                        }

                        // Info column
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = show.name,
                                modifier = Modifier.padding(bottom = 10.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Button(
                                onClick = {
                                    val webIntent: Intent =
                                        Uri.parse(show.linkSite).let { webpage ->
                                            Intent(Intent.ACTION_VIEW, webpage)
                                        }
                                    context.startActivity(webIntent)
                                },
                                modifier = Modifier.padding(bottom = 16.dp)
                            ) {
                                Text(text = "Visit Site")
                            }

                            Text(
                                text = show.network,
                                modifier = Modifier.padding(top = 12.dp),
                                fontSize = 15.sp
                            )

                            Text(
                                text = "Rating: ${show.rating}",
                                modifier = Modifier.padding(top = 8.dp),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                            TextWithTitle(title = "Sinopsis", body = show.synopsis)

                            MyLazyRowTalents(talents)
                        }
                    }

                }
            }
        }
    }
}




@Composable
private fun LazyListState.calculateDelayAndEasing(index: Int, columnCount: Int): Pair<Int, Easing> {
    val row = index / columnCount
    val column = index % columnCount
    val firstVisibleRow = firstVisibleItemIndex
    val visibleRows = layoutInfo.visibleItemsInfo.count()
    val scrollingToBottom = firstVisibleRow < row
    val isFirstLoad = visibleRows == 0
    val rowDelay = 100 * when {
        isFirstLoad -> row // initial load
        scrollingToBottom -> visibleRows + firstVisibleRow - row // scrolling to bottom
        else -> 1 // scrolling to top
    }
    val scrollDirectionMultiplier = if (scrollingToBottom || isFirstLoad) 1 else -1
    val columnDelay = column * 100 * scrollDirectionMultiplier
    val easing =
        if (scrollingToBottom || isFirstLoad) LinearOutSlowInEasing else FastOutSlowInEasing
    return rowDelay + columnDelay to easing
}


@Composable
fun scaleAndAlpha(
    args: ScaleAndAlphaArgs,
    animation: FiniteAnimationSpec<Float>
): Pair<Float, Float> {
    val transitionState =
        remember {
            MutableTransitionState(StateAnimation.PLACING).apply {
                targetState = StateAnimation.PLACED
            }
        }
    val transition = updateTransition(transitionState)
    val alpha by transition.animateFloat(transitionSpec = { animation }, label = "") { state ->
        when (state) {
            StateAnimation.PLACING -> args.fromAlpha
            StateAnimation.PLACED -> args.toAlpha
        }
    }
    val scale by transition.animateFloat(transitionSpec = { animation }, label = "") { state ->
        when (state) {
            StateAnimation.PLACING -> args.fromScale
            StateAnimation.PLACED -> args.toScale
        }
    }
    return alpha to scale
}

@Composable
fun rotation(
    args: RotationArgs,
    animation: FiniteAnimationSpec<Float>
): Float {
    val transitionState =
        remember {
            MutableTransitionState(StateAnimation.PLACING).apply {
                targetState = StateAnimation.PLACED
            }
        }
    val transition = updateTransition(transitionState)

    val rotation by transition.animateFloat(transitionSpec = { animation }, label = "") { state ->
        when (state) {
            StateAnimation.PLACING -> args.fromRotation
            StateAnimation.PLACED -> args.toRotation
        }
    }
    return rotation
}