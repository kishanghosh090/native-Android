package com.vedabits.wishlistapp.data

data class Wish(
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
)

object DummyWish{
    val wishList = listOf(
        Wish(
            title = "Wish 1",
            description = "Description 1"
        ),
        Wish(
            title = "Wish 2",
            description = "Description 2"
        ),
        Wish(
            title = "Wish 3",
            description = "Description 3"
        ),
        Wish(
            title = "Wish 4",
            description = "Description 4"
        ),
        Wish(
            title = "Wish 5",
            description = "Description 5"
        ),
    )
}