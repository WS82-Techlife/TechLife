package com.example.techlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_projects.*


class Projects : AppCompatActivity(), OnItemClickListenerProject {

    override fun OnItemClicked(project: Project) {
    }

    lateinit var projects : List<Project>

    lateinit var projectAdapter : ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        val actionBar = supportActionBar
        actionBar!!.title = "Proyectos de tu Interes"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onResume() {
        super.onResume()
        loadProjects()

        projectAdapter = ProjectAdapter(projects, this)
        rvProject.adapter = projectAdapter
        rvProject.layoutManager = LinearLayoutManager(this)
    }

    private fun loadProjects() {
        projects = AppDatabaseProject.getInstance(this).getDao().getAll()
    }


}