package br.senai.sp.jandira.loginsynbian.componenents

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import br.senai.sp.jandira.loginsynbian.componenents.API.ApiService
import br.senai.sp.jandira.loginsynbian.componenents.API.RetrofitHelper
import com.google.gson.JsonObject
import kotlinx.coroutines.launch


@Composable
fun BotaoLogin(
    textButton: String,
    corBotao: Color,
    imagem :String,
    email :String,
    senha:String,
    lifecycleScope: LifecycleCoroutineScope,
    logar: () -> Unit,


) {


    Button(
        onClick = { logar()
                  createUser(lifecycleScope, email, senha, imagem)
        },
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



private fun createUser( lifecycleScope:LifecycleCoroutineScope,login: String,senha: String,imagem: String) {

    lateinit var apiService: ApiService

    apiService = RetrofitHelper.getInstance().create(ApiService::class.java)


    lifecycleScope.launch {
        val body = JsonObject().apply {
            addProperty("login", login)
            addProperty("senha", senha)
            addProperty("imagem", imagem)


        }
        val result = apiService.createAccount(body)
        if (result.isSuccessful) {
            Log.i("GETTING-DATA", "${result.body()}")
        } else {
            Log.i("GETTING-DATA", "${result.message()}")
        }
    }
}

