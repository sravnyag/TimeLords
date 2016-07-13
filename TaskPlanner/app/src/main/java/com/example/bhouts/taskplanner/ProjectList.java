package com.example.bhouts.taskplanner;
import java.util.ArrayList;

/**
 * Created by bhouts on 7/10/2016.
 */
public class ProjectList {
    public String MyName;        //name
    public ArrayList<Task> TaskList = new ArrayList<Task>();   //list of tasks
    public ProjectList(){
        MyName = "All Projects";
        this.TaskList.add(Gbl.StartList);
    }
    public void newtask(Task DoThis){
        this.TaskList.add(DoThis);
    }
}
