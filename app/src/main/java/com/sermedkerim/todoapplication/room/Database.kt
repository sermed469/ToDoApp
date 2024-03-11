package com.sermedkerim.todoapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sermedkerim.todoapplication.data.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getToDoDao() : ToDoDao
}