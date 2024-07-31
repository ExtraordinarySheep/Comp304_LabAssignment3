package com.sylvia.sylvia_lab3.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sylvia.sylvia_lab3.model.Patient
import com.sylvia.sylvia_lab3.model.Test
import com.sylvia.sylvia_lab3.model.Nurse

@Database(entities = [Patient::class, Test::class, Nurse::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun patientDao(): PatientDao
    abstract fun testDao(): TestDao
    abstract fun nurseDao(): NurseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "sylvia_lab3_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
