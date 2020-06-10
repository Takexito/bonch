package com.example.bonchapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MessageBody(

    @SerializedName("text")
    @Expose
    val text: String,
    @SerializedName("subject")
    @Expose
    val subject: String,
    @SerializedName("messageType")
    @Expose
    val messageType: String,
    @SerializedName("item")
    @Expose
    val item: Int,
    @SerializedName("files")
    @Expose
    val files: List<File>
)