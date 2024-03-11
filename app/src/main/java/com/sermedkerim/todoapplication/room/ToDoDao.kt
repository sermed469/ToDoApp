package com.sermedkerim.todoapplication.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sermedkerim.todoapplication.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDos")
    suspend fun loadToDos():List<ToDo>

    @Insert
    suspend fun save(toDo: ToDo)

    @Update
    suspend fun update(toDo: ToDo)

    @Delete
    suspend fun delete(toDo: ToDo)

    @Query("SELECT * FROM toDos WHERE name LIKE '%'||:searchQuery||'%'")
    suspend fun search(searchQuery:String):List<ToDo>
}