package br.senai.sp.jandira.loginsynbian.componenents
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoSenhaLogin(
    value: String,
    aoMudar: (String) -> Unit,
    placeholder: String,
    isError: Boolean
) {


    var passwordVisibilityState by remember {
        mutableStateOf(false)
    }

    val errorText = remember { mutableStateOf("") }

    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            val transformedValue = aoMudar(newValue)

            errorText.value = ""

        },
        placeholder = {
            Text(text = placeholder, color = Color(0xFF606060))
        },
        modifier = Modifier
            .fillMaxWidth(),
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibilityState = !passwordVisibilityState
                }
            ) {
                Icon(
                    imageVector = if (passwordVisibilityState)

                        Icons.Default.VisibilityOff
                    else
                        Icons.Default.Visibility,
                    contentDescription = "",
                    tint = Color(0xFF606060)

                )
            }
        },
        isError = isError,
        visualTransformation = if (!passwordVisibilityState)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            containerColor = Color.White,
            unfocusedBorderColor = Color.White,
            focusedBorderColor = Color.White,
            cursorColor = Color.Black
        )
    )

}