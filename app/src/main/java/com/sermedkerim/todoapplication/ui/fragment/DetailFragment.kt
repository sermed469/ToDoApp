package com.sermedkerim.todoapplication.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.sermedkerim.todoapplication.R
import com.sermedkerim.todoapplication.databinding.FragmentDetailBinding
import com.sermedkerim.todoapplication.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(LayoutInflater.from(requireContext()),container,false)

        val args:DetailFragmentArgs by navArgs()

        binding.textInputLayoutUpdateToDo.editText?.setText(args.toDo.name)

        binding.buttonUpdate.setOnClickListener {
            if(binding.editTextDetailName.text.toString() != ""){

                viewModel.updateToDo(args.toDo.id,binding.editTextDetailName.text.toString())

                Snackbar.make(it,"${binding.editTextDetailName.text.toString()} is updated", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.GREEN)
                    .setTextColor(Color.WHITE)
                    .show()

                Navigation.findNavController(it).navigateUp()
            }else{
                Snackbar.make(it,"Please insert a name for to do", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.RED)
                    .setTextColor(Color.WHITE)
                    .show()
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: DetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}