package com.example.loginregsitration.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.loginregsitration.R
import com.example.loginregsitration.ui.theme.LoginRegsitrationTheme
import com.example.loginregsitration.viewModel.MoviesViewModel

@Composable
fun ListScreen(navController: NavHostController?) {
    Column() {
        AppBar()
        MainScreenList()
    }
}


@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Movies", textAlign = TextAlign.Center) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu Btn"
                )
            }
        },
        /*backgroundColor = lightBlue,*/
        contentColor = Color.White,
        elevation = 2.dp,
    )
}

@Composable
fun MainScreenList() {
    val viewModel: MoviesViewModel = viewModel()

    LazyColumn() {
        items(viewModel.moviesState.value) { model ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 10.dp),
                elevation = 6.dp
            ) {

                Row() {
                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(model.Poster)
                            .build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = "",
                        modifier = Modifier
                            .width(70.dp)
                            .height(100.dp)

                    )

                    Column(
                        modifier = Modifier
                            .weight(.5f)
                            .padding(10.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        model.Title?.let {
                            Text(
                                text = it,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(0.dp, 10.dp, 10.dp, 5.dp),
                                color = Color.Black
                            )
                        }

                        Text(
                            text = "${model.Runtime} | ${model.Year}",
                            fontSize = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 5.dp, 10.dp, 5.dp),
                            color = Color.Gray
                        )
                    }

                    Image(
                        painter = if (model.isLike)
                            painterResource(id = R.drawable.like)
                        else
                            painterResource(id = R.drawable.dislike),

                        contentDescription = "", modifier = Modifier.padding(13.dp)
                    )
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview1() {
    LoginRegsitrationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ListScreen(null)
        }
    }

}