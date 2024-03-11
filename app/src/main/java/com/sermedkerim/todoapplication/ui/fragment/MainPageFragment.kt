package com.sermedkerim.todoapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sermedkerim.todoapplication.R
import com.sermedkerim.todoapplication.data.entity.ToDo
import com.sermedkerim.todoapplication.databinding.FragmentMainPageBinding
import com.sermedkerim.todoapplication.ui.adapter.ToDoAdapter
import com.sermedkerim.todoapplication.ui.viewmodel.MainPageViewModel
import com.sermedkerim.todoapplication.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(LayoutInflater.from(requireContext()),container,false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel.toDoList.observe(viewLifecycleOwner){
            val adapter = ToDoAdapter(it,viewModel)
            binding.recyclerView.adapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if(p0.toString() != ""){
                    viewModel.search(p0.toString())
                }else{
                    viewModel.loadToDos()
                }

                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0.toString() != ""){
                    viewModel.search(p0.toString())
                }else{
                    viewModel.loadToDos()
                }

                return true
            }
        })

        binding.fabAddToDo.setOnClickListener{
            Navigation.navigate(it,R.id.navigationFromMainPageToSavePage)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : MainPageViewModel by viewModels()
        viewModel = tempViewModel
        viewModel.loadToDos()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadToDos()
    }
}