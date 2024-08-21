package com.physicswallah.rickandmorty.presentations.splash

import android.util.Log
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.physicswallah.rickandmorty.R
import com.physicswallah.rickandmorty.utils.navigation.RouteName
import com.physicswallah.rickandmorty.utils.textView16
import kotlinx.coroutines.delay

@Composable
@Preview
fun SplashScreen(navController: NavController? = null){
    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color.Black)) {
        // ExoPlayer video view
        Image(
            painter = painterResource(id = R.drawable.rickmorty),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        )
        LaunchedEffect(key1 = true){
            delay(3000)
            navController?.navigate(RouteName.HomeScreen.route){
                popUpTo(RouteName.Splash.route){inclusive = true}
            }
        }

            }
    }