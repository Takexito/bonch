package com.example.bonchapp.domain.util

class ResponseCallback<T> (
    val code: Int,
    val isSuccess: Boolean,
    val successBody: T,
    val errorBody: String
) {
    fun getMessage(): String?{
        return when(code){
            in 200..299 -> "Ok"
            in 300..399 -> "Redirect"
            401 -> "Данные введены не верно"
            in 400..499 -> "Произошла клиентская ошибка"
            in 500..599 -> "Произошла ошибка на сервере"
            else -> null
        }
    }
}
