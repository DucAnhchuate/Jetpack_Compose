package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun signUpScreen(
    navController: NavController,
) {
    var lastname by remember {
        mutableStateOf("")
    }

    var fisrtname by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = MaterialTheme.shapes.medium) // Optional: Clip the image with a shape
        )
    }
    Box(
        Modifier
            .fillMaxSize()
            .padding(28.dp)
            .alpha(0.4f)
            .clip(
                CutCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                )
            )
            .background(MaterialTheme.colors.background)
    )
    Column(
        Modifier
            .fillMaxHeight()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ) {
        signUpHeader()

        signUpField(fisrtname, lastname, email, password,
            onPasswordChange = {
                password = it
            },
            onEmailChange = {
                email = it
            },
            onFisrtNameChange = {
                fisrtname = it
            },
            onLastNameChange = {
                lastname = it
            },
        )

        signUpFooter(
            onSignUpClick = {},
            onSignInClick = {
                navController.popBackStack(Screen.ScreenLogin.route, false)
            }
        )
    }
}
@Composable
fun signUpHeader(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hi, there",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Create an Account",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}
@Composable
fun signUpField(fisrtName: String,
                            lastName: String,
                            email: String,
                            password: String,
                            onFisrtNameChange: (String) -> Unit,
                            onLastNameChange: (String) -> Unit,
                            onPasswordChange: (String) -> Unit,
                            onEmailChange: (String) -> Unit){
    Column (horizontalAlignment = Alignment.CenterHorizontally,
    ){
        demoLoginFields(
            value = fisrtName,
            label = "First Name",
            placeholder = "Enter your First Name",
            onValueChange = onFisrtNameChange,
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
        )
        demoLoginFields(
            value = fisrtName,
            label = "Last Name",
            placeholder = "Enter your Last Name",
            onValueChange = onLastNameChange,
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(8.dp))
        demoLoginFields(
            value = email,
            label = "Email",
            placeholder = "Enter your Last Name",
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(8.dp))
        demoLoginFields(
            value = password,
            label = "Password",
            placeholder = "Enter your Password",
            onValueChange = onPasswordChange,
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            )
        )
        Spacer(Modifier.height(8.dp))
        var checkedState = remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                })
            Text(
                 text = "By continuing you accept our Privacy Policy" +
                    " and Term of Use ",
                 //modifier = Modifier.width(230 .dp)
            )
        }
    }
}


@Composable
fun signUpFooter(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = onSignUpClick, Modifier.fillMaxWidth()) {
                Text(text = "Sign Up")

            }
            TextButton(onClick = onSignInClick,modifier = Modifier.fillMaxWidth()) {
                Text(text = "Already have an Account, click here")

            }
        }
}
@Composable
fun demoSignUpFields(
    value: String,
    label: String,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label
                )
            },
            placeholder = {
                Text(
                    text = placeholder
                )
            },
            visualTransformation = visualTransformation,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            maxLines = 1,
            singleLine = true,
        )
}