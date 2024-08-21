package com.physicswallah.rickandmorty.data.network

import android.util.Log
import com.physicswallah.rickandmorty.data.apis.RetrofitClint
import com.physicswallah.rickandmorty.data.modelClass.HomeDTO
import com.physicswallah.rickandmorty.data.modelClass.Results
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Repository {
    private val retrofit =  RetrofitClint.api
     fun getCharacterHome(): Flow<Response<HomeDTO>> = flow{
        emit(retrofit.getCharacterHome())
    }

    fun getCharacterDetails(id:Int): Flow<Response<Results>> = flow{
        emit(retrofit.getCharacterDetails(id))
    }
}