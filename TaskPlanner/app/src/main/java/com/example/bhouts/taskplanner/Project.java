package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Project extends ProjectList{

    public Project(String name){
        ProjName = name;
        //add project to global ProjectList "All Projects" as a Task
        Task task = new Task();
        task.setName(ProjName);
        task.setProject("All Projects");
        //add project as task to projTask
        Gbl.projList.addTask(Gbl.projList, task);
        //add Project to global String list of all projects
        Gbl.list_of_projects.add(task.getName());
        //must add project to "allProjectsDatabase" ArrayList along with the creation of a new Project (not done here)
    }
}