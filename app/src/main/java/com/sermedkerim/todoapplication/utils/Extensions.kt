package com.sermedkerim.todoapplication.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.navigate(it: View,id:Int){
    Navigation.findNavController(it).navigate(id)
}

fun Navigation.navigate(it: View,action:NavDirections){
    Navigation.findNavController(it).navigate(action)
}