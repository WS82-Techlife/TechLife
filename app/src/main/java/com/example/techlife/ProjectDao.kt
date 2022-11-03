package com.example.techlife

import androidx.room.*

@Dao
interface ProjectDao {

    //Aqui hago el CRUD
    @Query("select * from project")
    fun getAll(): List<Project>

    @Insert
    fun insertProject(vararg contact: Project)

    @Delete
    fun deleteProject(vararg contact: Project)

    @Update
    fun updateProject(vararg contact: Project)
}