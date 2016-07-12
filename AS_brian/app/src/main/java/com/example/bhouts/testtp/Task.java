package com.example.bhouts.testtp;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Task {
    public String Tname;    //task name
    public String Pname;	 //associated poject
    public String Notes;    //task description
    public Boolean Completed;
    public Task(String TaskName, String ProjectName, String Des){
        Tname = TaskName;
        Pname = ProjectName;
        Notes = Des;
        Completed = false;

    }
}

