package com.example.ebook1.data.RepoImpl

import com.example.ebook1.common.BookCategoryModel
import com.example.ebook1.common.BookModel
import com.example.ebook1.common.ResultState
import com.example.ebook1.domain.repo.AllBookRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AllBookRepoImpl @Inject constructor(val firebaseDatabase: FirebaseDatabase): AllBookRepo {
    override fun getAllBooks(): Flow<ResultState<List<BookModel>>> = callbackFlow {

        trySend(ResultState.Loading)
        val valueEvent = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var items: List<BookModel> = emptyList()
                items = snapshot.children.map { value ->
                    value.getValue(BookModel::class.java)!!
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }


    }

    override fun getAllCategory(): Flow<ResultState<List<BookCategoryModel>>> {
        TODO("Not yet implemented")
    }

    override fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>> {
        TODO("Not yet implemented")
    }
}