package com.example.jetpackcomposecourse.`2_fundamentalConcepts`

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecourse.R
import kotlin.math.max

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ResourceAccess(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.white))
            .padding(vertical = 42.dp, horizontal = 20.dp)


    ){
        AccessImageResource()


        Spacer(
            modifier = Modifier.height(7.dp)
        )
        Text(
            text = stringResource(R.string.app_name),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = colorResource(R.color.black),
            maxLines = 1

        )
    }

}

@Composable
fun AccessImageResource(){
    Box(
        modifier = Modifier.size(32.dp),

    ){
        Image(painter = painterResource(R.drawable.menu), contentDescription = "")
    }
}