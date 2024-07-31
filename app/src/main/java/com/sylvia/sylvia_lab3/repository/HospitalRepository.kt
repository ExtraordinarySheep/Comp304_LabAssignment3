package com.sylvia.sylvia_lab3.repository

import com.sylvia.sylvia_lab3.database.TestDao
import com.sylvia.sylvia_lab3.database.NurseDao
import com.sylvia.sylvia_lab3.database.PatientDao
import com.sylvia.sylvia_lab3.model.Patient
import com.sylvia.sylvia_lab3.model.Test
import com.sylvia.sylvia_lab3.model.Nurse
import kotlinx.coroutines.flow.Flow

class HospitalRepository(private val patientDao: PatientDao, private val testDao: TestDao, private val nurseDao: NurseDao) {

    val allPatients: Flow<List<Patient>> = patientDao.getAllPatients()

    suspend fun insertPatient(patient: Patient) {
        patientDao.insert(patient)
    }

    suspend fun updatePatient(patient: Patient) {
        patientDao.update(patient)
    }

    fun getTestsForPatient(patientId: Int): Flow<List<Test>> = testDao.getTestsForPatient(patientId)

    suspend fun insertTest(test: Test) {
        testDao.insert(test)
    }

    fun getNurseById(nurseId: Int): Flow<Nurse> = nurseDao.getNurseById(nurseId)

    suspend fun insertNurse(nurse: Nurse) {
        nurseDao.insert(nurse)
    }
}
