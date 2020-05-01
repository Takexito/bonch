package com.example.bonchapp.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Token(
    @SerializedName("token")
    var value: String) {

}