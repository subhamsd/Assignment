package com.physicswallah.rickandmorty.presentations.details

import androidx.lifecycle.ViewModel
import com.physicswallah.rickandmorty.data.modelClass.Results
import com.physicswallah.rickandmorty.data.network.Repository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class DetailScreenViewModel:ViewModel() {
    private val repo = Repository()
    fun getCharacterDetails(id:Int):Flow<Response<Results>>{
        return repo.getCharacterDetails(id)
    }
}

