package com.sylvia.sylvia_lab3.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sylvia.sylvia_lab3.database.AppDatabase
import com.sylvia.sylvia_lab3.repository.HospitalRepository
import kotlinx.coroutines.launch

class HospitalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: HospitalRepository

    init {
        val database = AppDatabase.getDatabase(application)
        repository = HospitalRepository(database.patientDao(), database.testDao(), database.nurseDao())
    }

    val allPatients = repository.allPatients.asLiveData()

    fun insertPatient(patient: Patient) = viewModelScope.launch {
        repository.insertPatient(patient)
    }

    fun getTestsForPatient(patientId: Int) = repository.getTestsForPatient(patientId).asLiveData()
}
