package com.example.data.repository.remote

data class ResponseModel<T> (
    val response : T? = null,
    val error : String? = null
)