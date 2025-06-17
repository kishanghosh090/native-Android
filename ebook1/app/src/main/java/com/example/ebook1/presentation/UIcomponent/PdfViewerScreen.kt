package com.example.ebook1.presentation.UIcomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import com.rizzi.bouquet.VerticalPDFReader

@Composable
fun PdfViewerScreen(
    url: String,
) {
    var isDarkMode by remember {
        mutableStateOf(false)
    }
    val pdfState = rememberVerticalPdfReaderState(resource = ResourceType.Remote(url), isZoomEnable = true)

    VerticalPDFReader(
        state = pdfState,
        modifier = Modifier.fillMaxSize().background(color = Color.Gray),
    )
}