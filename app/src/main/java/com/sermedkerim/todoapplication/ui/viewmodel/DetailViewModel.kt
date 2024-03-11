package com.sermedkerim.todoapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sermedkerim.todoapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var repo:ToDoRepository) :ViewModel() {
    fun updateToDo(id:Int,name:String){
        CoroutineScope(Dispatchers.Main).launch {
            repo.updateToDo(id,name)
        }
    }
}