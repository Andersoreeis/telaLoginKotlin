package br.senai.sp.jandira.loginsynbian.componenents.API

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    var data: T? = null
)