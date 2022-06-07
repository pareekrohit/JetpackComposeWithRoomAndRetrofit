package com.example.loginregsitration.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.loginregsitration.R
import com.example.loginregsitration.ui.theme.LoginRegsitrationTheme


@Composable
fun LoginScreen(navController: NavHostController?) {
    Column(modifier = Modifier.padding(15.dp)) {
        Image(
            painter = painterResource(id = R.drawable.bike),
            contentDescription = "",
            modifier = Modifier
                .width(250.dp)
                .height(160.dp)
                .padding(0.dp, 15.dp, 0.dp, 0.dp)
        )

        MainScreenLogin(navController)
    }
}


@Composable
fun MainScreenLogin(navController: NavHostController?) {
    Column(
        modifier = Modifier
            .padding(0.dp, 15.dp, 0.dp, 0.dp)
    ) {

        Text(
            text = "HELLO THERE \nWELCOME BACK",
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.lobster_bold)),
        )

        Text(
            text = "Sign In to continue",
            fontSize = 16.sp, modifier = Modifier.padding(0.dp, 10.dp),
            color = Color.Gray
        )

        /*keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)*/
        val username = remember { mutableStateOf("") }
        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
            },
            label = { Text("Username") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Gray,
                unfocusedBorderColor = Black
            ),
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            singleLine = true,

            keyboardOptions = KeyboardOptions.Default.copy(
                capitalization = KeyboardCapitalization.Sentences,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
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
                focusedBorderColor = Gray,
                unfocusedBorderColor = Black
            ),

            /*keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),*/

            trailingIcon = {
                val image = if (passwordVisible.value) visible
                else visibleOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisible.value) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = image, description)
                }
            }, maxLines = 1,
            singleLine = true,

           /* keyboardActions = KeyboardActions(onDone = {
                this.clearFocus() }),*/
            keyboardOptions = KeyboardOptions
                .Default.copy(imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password),
        )



        Text(
            text = "FORGET PASSWORD?",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(0.dp, 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Black
        )

        Button(
            onClick = {
                Log.d("LoginScreenUI", "Button Clicked")

                navController?.navigate("listScreen")
            },
            colors = ButtonDefaults.buttonColors(Black, contentColor = White),
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {
            Text(text = "GO")
        }


        Text(
            text = "NEW USER? SIGN UP",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(0.dp, 15.dp)
                .fillMaxWidth()
                .clickable {
                    Log.d("LoginScreenUI", "Text Clicked")
                    navController?.navigate("registration")
                },
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginRegsitrationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LoginScreen(null)
        }
    }

}