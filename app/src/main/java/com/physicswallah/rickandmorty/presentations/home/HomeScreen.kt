package com.physicswallah.rickandmorty.presentations.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.physicswallah.rickandmorty.R
import com.physicswallah.rickandmorty.data.modelClass.HomeDTO
import com.physicswallah.rickandmorty.presentations.details.DetailView
import com.physicswallah.rickandmorty.presentations.details.LandscapeDetailView
import com.physicswallah.rickandmorty.utils.navigation.RouteName
import com.physicswallah.rickandmorty.utils.textView20
import com.physicswallah.rickandmorty.utils.textView30
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel:HomeViewModel = ViewModelProvider(LocalContext.current as ViewModelStoreOwner)[HomeViewModel::class.java]
Scaffold(modifier = Modifier.background(Color.Black)) {
    Column(modifier = Modifier.background(Color.Black).fillMaxSize()) {
        AppBar()
        SetData(viewModel,navController)
    }
    it.calculateTopPadding()
}
}

@Composable
fun AppBar(){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
    Arrangement.Center, modifier = Modifier.padding(top = 50.dp, start = 16.dp).fillMaxWidth()) {
        Image(painter = painterResource(id =  R.drawable.rickmorty),
            contentDescription = "Image",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape))
        Text(text = "Rick and Morty", style = textView30.bodyLarge.copy(color = Color.White),
            modifier = Modifier
                .padding(start = 16.dp)
                .width(200.dp))
    }

}

@Composable
fun ListOfChar(itemList:HomeDTO,navController: NavController){
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(itemList.results.size){
            val id = itemList.results[it].id
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .padding(8.dp)
                    .clickable {
                        navController.navigate(RouteName.DetailScreen.createRoute(id ?: 2))
                        Log.d("ListOfEpisodeTAG", "ListOfEpisode: $id")
                    }
                    .background(color = Color.DarkGray)
                    .fillMaxWidth(),
            ){
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    AsyncImage(model = itemList.results[it].image ?: "",
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape))
                    Text(
                        text = itemList.results[it].name ?: "",
                        style = textView20.bodyLarge.copy(color = Color.White),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(200.dp)
                    )
                }
            }
            }

    }
}


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SetData(viewModel: HomeViewModel,navController: NavController){
    val characterHome by viewModel.getCharacterHome().collectAsState(initial = null)
    characterHome?.body()?.let {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Box(modifier = Modifier.padding(bottom = 8.dp)) {
                    ListOfChar(it, navController)
                }
            }
            else -> {
                Box(modifier = Modifier.padding(bottom = 50.dp)) {
                    ListOfChar(it, navController)
                }
            }
        }
    }

    }
