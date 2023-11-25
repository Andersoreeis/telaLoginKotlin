package br.senai.sp.jandira.loginsynbian.componenents.API

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("usuario/cadastrarUsuario")
    suspend fun createAccount(@Body body: JsonObject) : Response<JsonObject>
}