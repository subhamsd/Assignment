package com.physicswallah.rickandmorty.presentations.details

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.physicswallah.rickandmorty.data.modelClass.Results
import com.physicswallah.rickandmorty.utils.textView14
import com.physicswallah.rickandmorty.utils.textView20
import com.physicswallah.rickandmorty.utils.textView30

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController?,id:Int) {
    val viewModel:DetailScreenViewModel = ViewModelProvider(LocalContext.current as
            ViewModelStoreOwner)[DetailScreenViewModel::class.java]
    Box() {
        Scaffold(
            Modifier
                .background(Color.Black)
                .fillMaxWidth(),
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Black,
                        titleContentColor = Color.White,
                    ),
                    title = {
                        Text(
                            "Episode Details",
                            style = textView20.bodyLarge.copy(color = Color.White)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController?.popBackStack()
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                tint = Color.White,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                )
            }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it).background(Color.Black)
            ) {
                SetData(viewModel, id)
            }
            Log.d("DetailScreenTAG", "DetailScreen: $id")

        }

    }
}

@Composable
@Preview
fun DetailView(data:Results){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp),
            model = data.image,
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds,
        )


        Text(text = data.name ?: "", style = textView30.bodyLarge.copy(color = Color.White), textAlign = TextAlign.Center)
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Status- ${data.status ?: ""}",
                style = textView14.bodyLarge.copy(color = Color.White),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp)
                    .weight(1f)
            )
            Text(
                text = "Species- ${data.species ?: ""}",
                style = textView14.bodyLarge.copy(color = Color.White),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp)
                    .weight(1f)
            )
        }
        Text(
            text = "Location-${data.location?.name ?: ""}",
            style = textView14.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(end = 8.dp, start = 8.dp)
        )

        ListOfEpisode(itemList = data)
    }
    }

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SetData(viewModel: DetailScreenViewModel,id:Int){
    val viewModel by viewModel.getCharacterDetails(id).collectAsState(initial = null)
    viewModel?.body()?.let {
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
               LandscapeDetailView(data = it)
            }
            else -> {
                DetailView(it)
            }
        }
    }
}

@Composable
fun ListOfEpisode(itemList: Results){
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(itemList.episode.size) {
//            val id = itemList.episode[it].id
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .padding(8.dp)
                    .background(color = Color.DarkGray)
                    .fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = itemList.image,
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    Text(
                        text = "Episode ${it + 1}",
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




@Composable
fun LandscapeDetailView(data:Results){
    Column(
        modifier = Modifier){
        Row {
            AsyncImage(
                modifier = Modifier
                    .height(100.dp)
                    .padding(8.dp),
                model = data.image,
                contentDescription = "Image",
                contentScale = ContentScale.Fit,
            )
            Column {
                Text(text = data.name ?: "", style = textView30.bodyLarge.copy(color = Color.White))
                    Text(text =  "Status ${data.status?:""}", style = textView14.bodyLarge.copy(color = Color.White),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(end = 8.dp, start = 8.dp))
                    Text(text = "Species ${data.species?:""}", style = textView14.bodyLarge.copy(color = Color.White),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(end = 8.dp, start = 8.dp))
                Text(text = "Location ${data.location?.name?:""}", style = textView14.bodyLarge.copy(color = Color.White),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(end = 8.dp, start = 8.dp))

            }

        }
        LandscapeListOfEpisode(data)
    }
}
@Composable
fun LandscapeListOfEpisode(itemList: Results){
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(itemList.episode.size) {
//            val id = itemList.episode[it].id
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .padding(8.dp)
                    .background(color = Color.DarkGray)
                    .fillMaxWidth(),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = itemList.image,
                        contentDescription = "Image",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                    Text(
                        text = "Episode ${it + 1}",
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