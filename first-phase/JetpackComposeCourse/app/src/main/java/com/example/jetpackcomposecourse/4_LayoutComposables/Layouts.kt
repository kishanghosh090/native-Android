package com.example.jetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun ColumnExample(){
    Column (
        modifier = Modifier.fillMaxSize().padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(34.dp)
    ){
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        Text(text = "Jetcpack compose")
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(1.dp, Color.Black)
                .clip(RoundedCornerShape(23.dp)),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp),



        ) {
            items(10) { index ->
                Box(
                    modifier = Modifier.clip(RoundedCornerShape(18.dp))
                ) {
                    Text(
                        text = "Item $index",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(16.dp)
                    )
                }
            }

        }

    }



}


// ConstarintLayout
@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun contrainLayouts(){
    Column {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray)
        ) {
            val (text1,text2,text3) = createRefs()
            Text(text = "bottom left",
                modifier = Modifier.constrainAs(text1) {
                    bottom.linkTo(parent.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
            )
            Text(text = " center",
                modifier = Modifier.constrainAs(text2) {
                    top.linkTo(parent.top, )
                    bottom.linkTo(parent.bottom, )
                    start.linkTo(parent.start, )
                    end.linkTo(parent.end, )
                }
            )
            Text(text = "top right",
                modifier = Modifier.constrainAs(text3) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)

                }
            )

        }
    }
}
