package com.example.bhouts.taskplanner;

import android.support.design.widget.FloatingActionButton;

import java.util.ArrayList;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Gbl {

    public static ProjectList All = new ProjectList();
    public static Task StartList = new Task(); //first task will simply show "TO DO:"

    public static Boolean hidden = Boolean.TRUE;
    public static FloatingActionButton fab_task;
    public static FloatingActionButton fab_project;
    public static FloatingActionButton fab_show;
    public static String passProjName = "New Project";


    //Projectlist with all projects as tasklist
    public static ProjectList projList = new ProjectList();

    //list to hold all project names
    public static ArrayList<String> list_of_projects = new ArrayList<String>();

    //need better database to hold projects..searchable for name to retrieve project
    public static ArrayList<ProjectList> allProjectsDatabase = new ArrayList<ProjectList>();

    //check if project already exists via String Name
    public static boolean isProject(String name){
        return Gbl.list_of_projects.contains(name);
    }

    //get position in ArrayList of project
    public static int getPos(String projName) {
        int size = Gbl.list_of_projects.size();
        for (int i=0; i<size ; i++){
            if (Gbl.list_of_projects.get(i).equals(projName)){
                return i;
            }
        }
        return (-1); //would be an error
    }

    //check to see if task's project already exists, if not create new project then add
    public static void addTaskToProj(Task task, String ProjName){
        if (Gbl.isProject(ProjName)){
            //add task to project
            int pos = Gbl.getPos(ProjName);
            Gbl.allProjectsDatabase.get(pos).addTask(Gbl.allProjectsDatabase.get(pos), task);
        }else{
            //create new project
            Project newProject = new Project(ProjName);
            //add to all projects Databse
            Gbl.allProjectsDatabase.add(newProject);

        }
    }

}
