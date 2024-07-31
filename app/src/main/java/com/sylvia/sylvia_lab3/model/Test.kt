package com.sylvia.sylvia_lab3.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tests")
data class Test(
    @PrimaryKey(autoGenerate = true) val testId: Int = 0,
    val patientId: Int,
    val nurseId: Int,
    val bpl: String,
    val bph: String,
    val temperature: String,
    val bloodSugar: String,
    val heartRate: String
)
