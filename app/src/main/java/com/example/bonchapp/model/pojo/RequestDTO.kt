package com.example.bonchapp.model.pojo

import com.google.gson.annotations.SerializedName

data class RequestDTO (

    @SerializedName("range") val range : Int = 0,
    @SerializedName("info") val info : Info,
    @SerializedName("date") val date : Date
)
data class Info (

    @SerializedName("type") val type : String = "group",
    @SerializedName("text") val text : String = "ИКТ-802"
)
data class Date (

    @SerializedName("from") val from : String = "2020-02-12",
    @SerializedName("to") val to : String = "2020-02-12"
)
