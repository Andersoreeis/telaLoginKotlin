package br.senai.sp.jandira.loginsynbian.componenents

import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import retrofit2.http.Url


@Composable
fun BotaoLogin(
    textButton: String,
    corBotao: Color,
    logar: () -> Unit,
    imagem :String,
    email :String,
    senha:String

) {
    Button(
        onClick = { logar() },
        modifier = Modifier
            .width(230.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(Color(0, 0, 0, 90)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = textButton,
            color = corBotao,
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
        )
    }
}





