package com.example.bonchapp.model.pojo

data class RequestTimeTableDTO (

    val range : Int = 0,
    val info : Info,
    val date : Date
)
data class Info (

    val type : String = "group",
    val text : String = "ИКТ-802"
)
data class Date (

    val from : String = "2020-02-12",
    val to : String = "2020-02-29"
)
