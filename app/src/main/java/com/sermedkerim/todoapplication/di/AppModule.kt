package com.sermedkerim.todoapplication.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sermedkerim.todoapplication.data.datasource.ToDoDataSource
import com.sermedkerim.todoapplication.data.repo.ToDoRepository
import com.sermedkerim.todoapplication.room.Database
import com.sermedkerim.todoapplication.room.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideToDoRepository(dataSource:ToDoDataSource):ToDoRepository{
        return ToDoRepository(dataSource)
    }

    @Singleton
    @Provides
    fun provideToDoDataSource(dao:ToDoDao):ToDoDataSource{
        return ToDoDataSource(dao)
    }

    @Singleton
    @Provides
    fun provideToDoDao(@ApplicationContext context: Context):ToDoDao{
        val db = Room.databaseBuilder(context,Database::class.java,"tododb.sqlite")
            .createFromAsset("tododb.sqlite")
            .build()

        return db.getToDoDao()
    }
}