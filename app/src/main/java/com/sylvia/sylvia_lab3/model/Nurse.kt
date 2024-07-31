package com.sylvia.sylvia_lab3.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nurses")
data class Nurse(
    @PrimaryKey val nurseId: Int,
    val firstname: String,
    val lastname: String,
    val department: String,
    val password: String
)
