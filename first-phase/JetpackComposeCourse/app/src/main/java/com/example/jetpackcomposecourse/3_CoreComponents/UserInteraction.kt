package com.example.jetpackcomposecourse.`3_CoreComponents`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview


@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun PartiallySelectableText(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        SelectionContainer {
            Column() {
                Text(text = "i love jetpack compose")
                Text(text = "i love kotlin")
                Text(text = "i love kotlin")
                Text(text = "i love kotlin")
                Text(text = "i love kotlin")
                Text(text = "i love kotlin")
                DisableSelection {
                    Text(text = "i love jetpack compose")
                    Text(text = "i love kotlin")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AnotatedStringWithListner(){
    val uriHandler = LocalUriHandler.current
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            buildAnnotatedString {
                append("Build better apps faster with ")
                val link = LinkAnnotation.Url(
                    url = "https://kishanranaghosh.xyz",

                     TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue,
                            )
                    )
                ){
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url)
                }
                withLink (link){
                    append("Kishan Rana")
                }

            }
        )
    }
}