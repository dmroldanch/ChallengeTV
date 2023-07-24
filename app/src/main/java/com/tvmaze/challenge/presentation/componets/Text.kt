package com.tvmaze.challenge.presentation.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tvmaze.challenge.presentation.theme.PrimaryColor

@Composable
fun TextWithTitle(title : String, body: String){
    Text(
        text = title,
        modifier = Modifier.padding(start = 8.dp, top = 8.dp,end= 8.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Box(Modifier.padding(start= 8.dp)) {
        Divider(
            Modifier
                .height(2.dp)
                .width(40.dp)
                .background(PrimaryColor)
        )
    }
    Text(
        text = body ?: "",
        modifier = Modifier.padding(top = 12.dp, start = 8.dp),
        fontSize = 15.sp
    )
}