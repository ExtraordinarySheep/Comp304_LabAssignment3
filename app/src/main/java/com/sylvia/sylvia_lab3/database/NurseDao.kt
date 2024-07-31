package com.sylvia.sylvia_lab3.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sylvia.sylvia_lab3.model.Nurse

@Dao
interface NurseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(nurse: Nurse)

    @Update
    fun update(nurse: Nurse)

    @Delete
    fun delete(nurse: Nurse)

    @Query("SELECT * FROM nurses WHERE nurseId = :nurseId")
    fun getNurseById(nurseId: Int): LiveData<Nurse>
}
