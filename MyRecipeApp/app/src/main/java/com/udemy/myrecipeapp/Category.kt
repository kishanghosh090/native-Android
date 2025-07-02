package com.udemy.myrecipeapp
//https://www.themealdb.com/api/json/v1/1/categories.php
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,
)

data class CategoriesResponse(val categories: List<Category>)