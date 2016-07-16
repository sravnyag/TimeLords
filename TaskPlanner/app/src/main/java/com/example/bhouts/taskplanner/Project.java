package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Project extends ProjectList{

    public Project(){
        //add project to global ProjectList "All Projects"
        Task task = new Task();
        task.setName(task, ProjName);
        task.setProject(task, "All Projects");
        addTask(Gbl.allProjects, task);
    }
}