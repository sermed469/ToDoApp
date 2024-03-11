package com.sermedkerim.todoapplication.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.snackbar.Snackbar
import com.sermedkerim.todoapplication.data.entity.ToDo
import com.sermedkerim.todoapplication.databinding.TodoCardItemBinding
import com.sermedkerim.todoapplication.ui.fragment.MainPageFragmentDirections
import com.sermedkerim.todoapplication.ui.viewmodel.MainPageViewModel
import com.sermedkerim.todoapplication.utils.navigate

class ToDoAdapter(var toDoList:List<ToDo>,var viewModel: MainPageViewModel) : RecyclerView.Adapter<ToDoAdapter.ToDoCardItemViewHolder>(){
    inner class ToDoCardItemViewHolder(var binding: TodoCardItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoCardItemViewHolder {
        val binding = TodoCardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoCardItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoCardItemViewHolder, position: Int) {
        val toDo = toDoList.get(position)

        holder.binding.textViewCardItemName.text = toDo.name
        holder.binding.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Are you delete?",Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(Color.RED)
                .setActionTextColor(Color.RED)
                .setAction("Yes"){

                    viewModel.delete(toDo.id)

                    Snackbar.make(it,"${toDo.name} is deleted.",Snackbar.LENGTH_SHORT)
                        .setBackgroundTint(Color.RED)
                        .setTextColor(Color.WHITE)
                        .show()
                }
                .show()
        }
        holder.binding.cardViewToDo.setOnClickListener {
            val action = MainPageFragmentDirections.navigationFromMainPageToDetailPage(toDo)
            Navigation.navigate(it,action)
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

}