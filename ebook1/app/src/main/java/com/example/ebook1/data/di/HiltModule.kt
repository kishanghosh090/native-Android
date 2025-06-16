package com.example.ebook1.data.di

import com.example.ebook1.data.RepoImpl.AllBookRepoImpl
import com.example.ebook1.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule{
    @Provides
    @Singleton
    fun provideRealTimeDatabase(): FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }
    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage{
        return FirebaseStorage.getInstance()
    }

    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase): AllBookRepo{
        return AllBookRepoImpl(firebaseDatabase)
    }
}