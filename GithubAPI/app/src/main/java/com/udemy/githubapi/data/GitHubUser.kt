package com.udemy.githubapi.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class GitHubUser(
    val login: String,
    val name: String?,
    val avatar_url: String,
    val followers: Int
): Parcelable
