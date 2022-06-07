package com.example.loginregsitration.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginregsitration.R
import com.example.loginregsitration.ui.theme.LoginRegsitrationTheme

@Composable
fun RegistrationScreen(navController: NavHostController?) {
    Column(modifier = Modifier.padding(15.dp)) {
        Image(
            painter = painterResource(id = R.drawable.bike),
            contentDescription = "",
            modifier = Modifier
                .width(250.dp)
                .height(160.dp)
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
        )

        MainScreenRegistration(navController = navController)
    }
}

@Composable
fun MainScreenRegistration(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .padding(0.dp, 15.dp, 0.dp, 0.dp)
    ) {

        Text(
            text = "WELCOME,",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.lobster_bold)),
        )

        Text(
            text = "SignUp to start your new Journey",
            fontSize = 16.sp, modifier = Modifier.padding(0.dp, 10.dp),
            color = Color.Gray
        )

        /*keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)*/
        val fullName = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = { Text("Full Name") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black
            ),
            maxLines = 1,
            singleLine = true
        )

        val userName = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = userName.value,
            onValueChange = { userName.value = it },
            label = { Text("Username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black
            ),
            maxLines = 1,
            singleLine = true
        )

        val email = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            maxLines = 1,
            singleLine = true
        )

        val phone = remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone.value,
            onValueChange = { phone.value = it },
            label = { Text("Phone No") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            maxLines = 1,
            singleLine = true
        )


        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }
        val visible = ImageVector.vectorResource(id = R.drawable.visible)
        val visibleOff = ImageVector.vectorResource(id = R.drawable.visibile_off)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = { Text("Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Black
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

            trailingIcon = {
                val image = if (passwordVisible.value) visible
                else visibleOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = image, description)
                }
            },
            maxLines = 1,
            singleLine = true
        )


        Button(
            onClick = { navController?.navigate("listScreen") },
            colors = ButtonDefaults.buttonColors(Color.Black, contentColor = Color.White),
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Text(text = "GO")
        }


        Text(
            text = "ALREADY HAVE AN ACCOUNT? LOGIN",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(0.dp, 15.dp)
                .fillMaxWidth()
                .clickable { navController?.navigate("login") },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black
        )

    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    LoginRegsitrationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RegistrationScreen(null)
        }
    }

}