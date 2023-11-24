package br.senai.sp.jandira.loginsynbian.screen

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginsynbian.componenents.BotaoLogin
import br.senai.sp.jandira.loginsynbian.componenents.CampoEmailLogin
import br.senai.sp.jandira.loginsynbian.componenents.CampoSenhaLogin
import br.senai.sp.jandira.loginsynbian.componenents.SubirFoto
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

@Composable
fun ScreenLogin() {
    val estadoEmail = remember { mutableStateOf("") }
    val estadoSenha = remember { mutableStateOf("") }
    val estadoErroEmail = remember { mutableStateOf("") }
    val estadoErroSenha = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val fotoUri = remember { mutableStateOf<Uri?>(null) }

    val storageRef = FirebaseStorage.getInstance().reference.child("images")
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        fotoUri.value = it
    }
    Log.e("foto", "EditarFoto: ${fotoUri}")



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(255, 106, 7),
                        Color(255, 43, 43)
                    )
                )
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SubirFoto(fotoUri = fotoUri){
                launcher.launch("image/*")
            }
            Log.e("foto", fotoUri.value.toString())
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Sign In",
                    fontSize = 50.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(600)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            CampoEmailLogin(
                value = estadoEmail.value,
                keyboarActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Down) }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                aoMudar = { novoValor ->
                    estadoEmail.value = novoValor
                    estadoErroEmail.value = ""
                },
                placeholder = "Digite o email",
                isError = estadoErroEmail.value.isNotEmpty()
            )

            Spacer(modifier = Modifier.height(20.dp))

            CampoSenhaLogin(
                value = estadoSenha.value,
                aoMudar = { novoValor ->
                    estadoSenha.value = novoValor
                    estadoErroSenha.value = ""
                },
                placeholder = "Digite a senha",
                isError = estadoErroSenha.value.isNotEmpty()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                BotaoLogin(textButton = "Login", corBotao = Color.White, imagem = "", email = "", senha = "", ) {
                    fotoUri.value?.let { uri ->
                        uploadImage(imageUri = uri, storageRef, context)
                    }
                }
            }
        }
    }
}



private fun uploadImage(imageUri: Uri, storageRef: StorageReference, context: Context) {


    Log.d("UPLOAD", "Iniciando upload da imagem...")

    storageRef.putFile(imageUri).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            Log.d("UPLOAD", "Upload realizado com sucesso!")
            Toast.makeText(context, "Upload realizado com sucesso", Toast.LENGTH_LONG).show()
        } else {
            Log.e("UPLOAD", "Erro ao tentar realizar o upload: ${task.exception}")
            Toast.makeText(
                context,
                "Houve um erro ao tentar realizar o upload",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
