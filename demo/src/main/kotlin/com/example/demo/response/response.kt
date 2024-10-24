package com.example.model

data class JsendResponse<T>(
    val status: String,
    val data: T? = null,
    val message: String? = null,
    val code: Int? = null
)

