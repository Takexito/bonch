package com.example.bonchapp.domain.entities

data class AccountDTO(
    val birth_date: String = "",
    val course: String = "",
    val faculty: String = "",
    val fullname: String = "",
    val group: String = ""
)

data class DebtDTO(
    val course: Int = 0,
    val semester: Int = 0,
    val subject: String = "",
    val subject_type: String = ""
)

data class ElectiveDTO(
    val mark: String = "",
    val status: String = "",
    val subject: String = ""
)

data class MarkDTO(
    val course: Int = 0,
    val mark: String = "",
    val semester: Int = 0,
    val subject: String = ""
)
