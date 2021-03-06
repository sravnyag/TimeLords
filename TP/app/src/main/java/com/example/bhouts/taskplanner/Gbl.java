package com.example.bhouts.taskplanner;

import android.support.design.widget.FloatingActionButton;

import java.util.ArrayList;

/**
 * Created by bhouts on 7/10/2016.
 */

public class Gbl {
    //variable to keep track of when project and task fabs should be hidden
    public static Boolean hidden = Boolean.TRUE;
    //gbl variableso canexecutonce on hs start
  /*  public static Boolean once = Boolean.FALSE;

    //global prjectdump
    public static Project dump = new Project("Dump");
*/
    //fab buttons
    public static FloatingActionButton fab_task;
    public static FloatingActionButton fab_project;
    public static FloatingActionButton fab_show;

    //
    public static void hide_fab(){
        Gbl.fab_task.hide();
        Gbl.fab_project.hide();
        Gbl.hidden = Boolean.TRUE;
    }

    public static ProjectList dump = new ProjectList();

    public static ProjectList urgent = new ProjectList();

    //gbl varibale to pass the name of a project to so can display on editProjects header
    public static String passProjName = "New Project";

    //gbl varibale to pass the name of a task to so can display on editTaskss header
    public static String passTaskName = "New Task";

    //Projectlist with all projects as tasklist
    public static ProjectList projList = new ProjectList();

    //list to hold all project names
    public static ArrayList<String> list_of_projects = new ArrayList<String>();

    //list of possible priority levels
    public static ArrayList<String> priority_levels = new
            ArrayList<String>(){{
                add("High");
                add("Med");
                add("Low");
                add("later...");
            }};

    //list of possible tags
    public static ArrayList<String> tags = new
            ArrayList<String>(){{
                add("Work");
                add("Home");
                add("Sports");
                add("Friends");
                add("Family");
            }};

    //need better database to hold projects..searchable for name to retrieve project
    public static ArrayList<ProjectList> allProjectsDatabase = new ArrayList<ProjectList>();

    //check if project already exists via String Name
    public static boolean isProject(String name){
        for (int i = 0; i<allProjectsDatabase.size();i++ ) {
            if (Gbl.allProjectsDatabase.get(i).getProjName().equals(name)){
                return true;
            }
        }
        return false;
        //return Gbl.list_of_projects.contains(name);
    }

    //return projectList with associated name
    public static ProjectList getProjWithName(String name){
        int pos = getPos(name);
        return Gbl.allProjectsDatabase.get(pos);
    }

    //get position in ArrayList of project
    public static int getPos(String projName) {
        int size = Gbl.list_of_projects.size();
        for (int i=0; i<size ; i++){
            if (Gbl.list_of_projects.get(i).equals(projName)){
                return i;
            }
        }
        return (0); //would be an error
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
