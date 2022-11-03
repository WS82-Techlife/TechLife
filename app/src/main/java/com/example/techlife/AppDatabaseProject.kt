package com.example.techlife

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Project::class), version = 1)
abstract class AppDatabaseProject: RoomDatabase() {

    abstract fun getDao(): ProjectDao

    //utiliza un patron singleton
    companion object{
        private var INSTANCE: AppDatabaseProject? = null

        fun getInstance(context: Context): AppDatabaseProject{
            if (INSTANCE == null){
                INSTANCE = Room
                    .databaseBuilder(context, AppDatabaseProject::class.java, "project.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDatabaseProject
        }
    }
}