package com.example.techlife

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add_project.*

class Add_Project : AppCompatActivity() {

    lateinit var project: Project

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_project)

        val actionBar = supportActionBar
        actionBar!!.title = "Agregar Proyecto"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val btProject_save = findViewById<Button>(R.id.btProject_save)
        val btProject_cancel = findViewById<Button>(R.id.btProject_cancel)
        loadProject()

        btProject_save.setOnClickListener {
            saveProject()
        }

        btProject_cancel.setOnClickListener {
            deleteProject()
        }
    }

    private fun loadProject() {
        val gson = Gson()
        val stringObj = intent.getStringExtra("project")

        project = gson.fromJson(stringObj, Project::class.java) ?: Project(null, "", "","","","","")

        if (project.id != null){
            etProjectName.setText(project.name)
            etDescription.setText(project.description)
            etNameOng.setText(project.ongname)
            etDirection.setText(project.direction)
            etDuration.setText(project.duration)
            etStart.setText(project.dateStart)
        }
    }

    private fun deleteProject() {
        AppDatabaseProject.getInstance(this).getDao().deleteProject(project)
        finish()
    }

    fun saveProject(){
        //modifico el metodo grabar
        project.name = etProjectName.text.toString()
        project.description =  etDescription.text.toString()
        project.ongname = etNameOng.text.toString()
        project.direction = etDirection.text.toString()
        project.duration = etDuration.text.toString()
        project.dateStart = etStart.text.toString()

        //es un contacto nuevo o ya existe?
        if (project.id != null){
            AppDatabaseProject.getInstance(this).getDao().updateProject(project)
        }
        else{
            AppDatabaseProject.getInstance(this).getDao().insertProject(project)
        }
        finish()
    }
}