package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Project extends ProjectList{

    public Project(){
        //add project to global ProjectList "All Projects" as a Task
        Task task = new Task();
        task.setName(task, ProjName);
        task.setProject(task, "All Projects");
        addTask(Gbl.projList, task);
        //add Project to global String list of all projects
        Gbl.list_of_projects.add(ProjName);
        //must add project to "allProjectsDatabase" ArrayList along with the creation of a new Project (not done here)
    }
}