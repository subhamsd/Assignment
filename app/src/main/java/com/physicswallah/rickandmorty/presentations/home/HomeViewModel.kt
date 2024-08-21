package com.physicswallah.rickandmorty.presentations.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.physicswallah.rickandmorty.data.modelClass.HomeDTO
import com.physicswallah.rickandmorty.data.network.Repository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class HomeViewModel:ViewModel() {
    private val repo = Repository()
     fun getCharacterHome(): Flow<Response<HomeDTO>> {
        return repo.getCharacterHome()
    }
}