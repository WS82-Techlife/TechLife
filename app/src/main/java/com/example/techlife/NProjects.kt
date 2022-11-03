package com.example.techlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_nprojects.*


class NProjects : AppCompatActivity(), OnItemClickListenerProject {

    override fun OnItemClicked(project: Project) {
        //CON ESTE CODIGO paso los valores al adddietrecipesActivity
        val intent = Intent(this, Add_Project::class.java)
        val gson = Gson()
        intent.putExtra("project", gson.toJson(project))
        startActivity(intent)
    }
    //lateinit var displayedList : List<Info>
    lateinit var projects: List<Project>

    //utilizo el adaptador del RV
    lateinit var projectAdapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nprojects)

        val actionBar = supportActionBar
        actionBar!!.title = "Proyectos"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val fab: View = findViewById(R.id.fabAdd_Project)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()

            val intent = Intent(this, Add_Project::class.java)
            startActivity(intent)
        }
    }

    //este metodo se carga en c/cambio
    override fun onResume() {
        super.onResume()
        loadProjects()

        projectAdapter = ProjectAdapter(projects, this)
        rvN_Project.adapter = projectAdapter
        rvN_Project.layoutManager = LinearLayoutManager(this)
    }

    private fun loadProjects() {
        projects = AppDatabaseProject.getInstance(this).getDao().getAll()
    }
}