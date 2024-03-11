package com.sermedkerim.todoapplication.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.sermedkerim.todoapplication.R
import com.sermedkerim.todoapplication.databinding.FragmentSaveBinding
import com.sermedkerim.todoapplication.ui.viewmodel.SaveViewModel
import com.sermedkerim.todoapplication.utils.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel : SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(LayoutInflater.from(requireContext()),container,false)

        binding.buttonSaveToDo.setOnClickListener {
            if(binding.editTextSaveName.text.toString() != ""){
                viewModel.saveToDo(binding.editTextSaveName.text.toString())
                Snackbar.make(it,"${binding.editTextSaveName.text.toString()} is saved",Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.GREEN)
                    .setTextColor(Color.WHITE)
                    .show()
                Navigation.findNavController(it).navigateUp()
            }else{
                Snackbar.make(it,"Please insert a name for to do",Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.RED)
                    .setTextColor(Color.WHITE)
                    .show()
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : SaveViewModel by viewModels()
        viewModel = tempViewModel
    }
}