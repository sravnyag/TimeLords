package com.example.bhouts.taskplanner;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Project {
    public Project(String ThisName){
        Task MyName = new Task(ThisName,"",""); //cast String as Task so can add to te global projectlist "All"
        Gbl.All.TaskList.add(MyName);
    }
}