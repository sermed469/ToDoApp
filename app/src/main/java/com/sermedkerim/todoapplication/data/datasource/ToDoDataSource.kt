package com.sermedkerim.todoapplication.data.datasource

import com.sermedkerim.todoapplication.data.entity.ToDo
import com.sermedkerim.todoapplication.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var dao: ToDoDao) {
    suspend fun loadToDos():List<ToDo> =
        withContext(Dispatchers.IO){
            return@withContext dao.loadToDos()
    }

    suspend fun saveToDo(name:String) =
        withContext(Dispatchers.IO){
            val toDo = ToDo(0,name)
            dao.save(toDo)
    }

    suspend fun updateToDo(id:Int,name:String) =
        withContext(Dispatchers.IO){
            val toDo = ToDo(id,name)
            dao.update(toDo)
    }

    suspend fun delete(id:Int) =
        withContext(Dispatchers.IO){
            val toDo = ToDo(id,"")
            dao.delete(toDo)
        }

    suspend fun search(searchQuery:String) : List<ToDo> =
        withContext(Dispatchers.IO){
            return@withContext dao.search(searchQuery)
    }
}