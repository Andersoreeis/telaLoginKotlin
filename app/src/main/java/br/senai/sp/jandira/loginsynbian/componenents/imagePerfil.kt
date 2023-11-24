package br.senai.sp.jandira.loginsynbian.componenents

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.loginsynbian.R

import coil.compose.AsyncImage

import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

@Composable
fun SubirFoto(fotoUri: MutableState<Uri?>, funcao: ()->Unit, ) {
    //Referencia para acesso e manipulação do cloud Storage e firestore
    lateinit var storageRef: StorageReference
    lateinit var fibaseFirestore: FirebaseFirestore
    storageRef = FirebaseStorage.getInstance().reference.child("images")
    fibaseFirestore = FirebaseFirestore.getInstance()



    var context = LocalContext.current

    //Criar o objeto que  abrirá a galeria e retornará a Uri da imagem selecionada

    Log.e("foto", "EditarFoto: ${fotoUri}")

    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(fotoUri.value).build()
    )



    Column(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(150.dp)
                .clickable {
                    funcao()

                },
            color = Color.White
        ) {

            AsyncImage(
                model = "",
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp),
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.baseline_person_24)
            )
            Image(
                painter = painter,
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(100.dp),
                contentScale = ContentScale.Crop
            )

        }

    }


}
