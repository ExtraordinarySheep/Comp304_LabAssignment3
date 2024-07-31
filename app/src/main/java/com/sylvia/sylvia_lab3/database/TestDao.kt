package com.sylvia.sylvia_lab3.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sylvia.sylvia_lab3.model.Test

@Dao
interface TestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(test: Test)

    @Update
    fun update(test: Test)

    @Delete
    fun delete(test: Test)

    @Query("SELECT * FROM tests WHERE patientId = :patientId")
    fun getTestsForPatient(patientId: Int): LiveData<List<Test>>
}
