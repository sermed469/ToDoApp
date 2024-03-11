package com.sermedkerim.todoapplication.data.repo

import com.sermedkerim.todoapplication.data.datasource.ToDoDataSource
import com.sermedkerim.todoapplication.data.entity.ToDo

class ToDoRepository(var dts:ToDoDataSource) {
    suspend fun loadToDos():List<ToDo> = dts.loadToDos()
    suspend fun saveToDo(name:String) = dts.saveToDo(name)
    suspend fun updateToDo(id:Int,name:String) = dts.updateToDo(id,name)
    suspend fun delete(id:Int) = dts.delete(id)
    suspend fun search(searchQuery:String):List<ToDo> = dts.search(searchQuery)
}