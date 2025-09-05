package com.example.ebook1.domain.repo

import com.example.ebook1.common.BookCategoryModel
import com.example.ebook1.common.BookModel
import com.example.ebook1.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {
    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>
}