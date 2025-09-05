package com.example.chatapp.data.network


data class GeminiRequest(val contents: List<GeminiContent>)
data class GeminiContent(val parts: List<GeminiPart>)
data class GeminiPart(val text: String)

data class GeminiResponse(val candidates: List<GeminiCandidate>)
data class GeminiCandidate(val content: GeminiContentResponse)
data class GeminiContentResponse(val parts: List<GeminiPartResponse>)
data class GeminiPartResponse(val text: String)

