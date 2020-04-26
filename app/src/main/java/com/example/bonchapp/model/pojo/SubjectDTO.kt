package com.example.bonchapp.pojo

import java.time.DayOfWeek

data class SubjectDTO(
    val time: String = "",
    val subject: String = "",
    val subject_type: String = "",
    val tutor: String = "",
    val place: String = "",
    val date:String = "",
    val dayOfWeek: Int = 1
)