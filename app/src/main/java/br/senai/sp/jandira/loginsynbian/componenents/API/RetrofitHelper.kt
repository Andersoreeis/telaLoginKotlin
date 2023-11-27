package br.senai.sp.jandira.loginsynbian.componenents.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//http://localhost3000/usuario/cadastrarUsuario


    private const val baseurl = "http://localhost:3000/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}