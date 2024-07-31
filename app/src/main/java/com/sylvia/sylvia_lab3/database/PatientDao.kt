package com.sylvia.sylvia_lab3.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sylvia.sylvia_lab3.model.Patient

@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(patient: Patient)

    @Update
    fun update(patient: Patient)

    @Delete
    fun delete(patient: Patient)

    @Query("SELECT * FROM patients WHERE nurseId = :nurseId")
    fun getPatientsByNurse(nurseId: Int): LiveData<List<Patient>>
}
