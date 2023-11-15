package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login();
                }
            }
        }
    }
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun Login(){
        var username by remember{
            mutableStateOf("")
        }

        var password by remember{
            mutableStateOf("")
        }

        Box(Modifier.background(Brush.linearGradient(
            colors = listOf(Color(0xff80D0C7), Color(0xff0093E9))
        )))
        Box(
            Modifier
                .fillMaxSize()
                .padding(28.dp)
                .alpha(0.6f)
                .clip(
                    CutCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 16.dp
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        )
        Column (
            Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            loginHeader()
            loginFields()
            loginFooter()
        }
    }
    @Composable
    fun loginHeader(){
        Text(text = "Welcome Back",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(text = "Sign in to continue",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

    }
    @Composable
    fun loginFields(username: String,
                    password: String,
                    onUsernameChange: (String) -> Unit,
                    onPasswordChange: (String) -> Unit){
        demoFields(value = username,
            label = "Username",
            placeholder = "Enter your email address",
            onValueChange = onUsernameChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            })
        demoFields(value = username,
            label = "Username",
            placeholder = "Enter your email address",
            onValueChange = onUsernameChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            })
        demoFields(value = username,
            label = "Username",
            placeholder = "Enter your email address",
            onValueChange = onUsernameChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            })
    }
    @Composable
    fun loginFooter(){

    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun demoFields(
        value: String,
        label: String,
        placeholder: String,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        leadingIcon: @Composable (() -> Unit)? = null,
        trailingIcon: @Composable (() -> Unit)? = null,
        onValueChange: (String) -> Unit
    )
    {
        OutlinedTextField(value = value,
            onValueChange = onValueChange,
            label = {
                Text(text = label
                )},
            placeholder = {
                Text(text = placeholder
                )},
            visualTransformation = visualTransformation,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon

        )
    }
}
