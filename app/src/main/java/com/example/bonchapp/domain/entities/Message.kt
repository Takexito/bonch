package com.example.bonchapp.domain.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Message(

        @SerializedName("destination")
        @Expose
        var teacher: String? = null,

        @SerializedName("subject")
        @Expose
        var theme: String? = null,

        @SerializedName("addressed_id")
        @Expose
        var addressId: Int? = null,

        @SerializedName("date")
        @Expose
        var date: String? = null,

        @SerializedName("files")
        @Expose
        var files: List<File>? = null,

        @SerializedName("id")
        @Expose
        var id: Int? = null,

        @SerializedName("read")
        @Expose
        var isRead: Boolean? = null,

        @SerializedName("text")
        @Expose
        var text: String? = null,

        @SerializedName("type")
        @Expose
        var type: String? = null
) : Serializable