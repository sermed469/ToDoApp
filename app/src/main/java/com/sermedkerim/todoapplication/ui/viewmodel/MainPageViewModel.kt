package com.sermedkerim.todoapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sermedkerim.todoapplication.data.entity.ToDo
import com.sermedkerim.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var repo:ToDoRepository):ViewModel() {
    var toDoList = MutableLiveData<List<ToDo>>()

    fun loadToDos(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = repo.loadToDos()
        }
    }

    fun delete(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            repo.delete(id)
            loadToDos()
        }
    }

    fun search(searchQuery:String){
        CoroutineScope(Dispatchers.Main).launch{
            toDoList.value = repo.search(searchQuery)
        }
    }
}