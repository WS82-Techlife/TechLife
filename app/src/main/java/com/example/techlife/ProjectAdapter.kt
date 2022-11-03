package com.example.techlife

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.prototype_projects.view.*

class ProjectAdapter(var projects: List<Project>, val itemClickListener: OnItemClickListenerProject):
    RecyclerView.Adapter<ProjectPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_projects, parent, false)

        return ProjectPrototype(view)
    }

    override fun onBindViewHolder(projectPrototype: ProjectPrototype, position: Int) {
        projectPrototype.bind(projects[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return projects.size
    }
}

class ProjectPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvProjName = itemView.tvProjName
    val tvProjDescription = itemView.tvProjDescription
    val tvOngName = itemView.tvOngName
    val tvDirection = itemView.tvDirection
    val tvProjDuration = itemView.tvProjDuration
    val tvStartDate = itemView.tvStartDate
    val cvProjects = itemView.cvProjects

    fun bind(project: Project, itemClickListener: OnItemClickListenerProject){
        tvProjName.text = project.name
        tvProjDescription.text = project.description
        tvOngName.text = project.ongname
        tvDirection.text = project.direction
        tvProjDuration.text = project.duration
        tvStartDate.text = project.dateStart

        cvProjects.setOnClickListener {
            itemClickListener.OnItemClicked(project)
        }
    }
}

interface OnItemClickListenerProject {
    fun OnItemClicked(project: Project)

}
