package com.example.bonchapp.pojo

data class SubjectDTO(
    val time: String = "",
    val subject: String = "",
    val subject_type: String = "",
    val tutor: String = "",
    val place: String = "",
    var pair: String = "",
    val date:String = "",
    val dayOfWeek: Int = 1
)