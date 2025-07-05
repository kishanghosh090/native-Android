package com.udemy.githubapi.data

data class GitHubUser(
    val login: String,
    val name: String?,
    val avatar_url: String,
    val followers: Int
)
