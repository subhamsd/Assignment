package com.physicswallah.rickandmorty.data.apis

import com.physicswallah.rickandmorty.data.modelClass.HomeDTO
import com.physicswallah.rickandmorty.data.modelClass.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("character")
    suspend fun getCharacterHome():
            Response<HomeDTO>

    @GET("character/{id}")
    suspend fun getCharacterDetails(
        @Path("id") id: Int):
            Response<Results>
}