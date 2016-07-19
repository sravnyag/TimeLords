package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Project {
    public Project(String projectName){
        Task MyName = new Task(); //cast String as Task so can add to te global projectlist "All"
        Gbl.All.TaskList.add(MyName);
    }
}