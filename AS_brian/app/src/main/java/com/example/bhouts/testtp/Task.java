package com.example.bhouts.testtp;
import java.util.Date;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Task {
    public String Tname;    //task name
    public String Pname;	 //associated poject
    public String Notes;    //task description
    public Boolean Completed;

    public Date dateCreated;
    public Date dateDue;

    public Task(String TaskName, String ProjectName, String Des){
        Tname = TaskName;
        Pname = ProjectName;
        Notes = Des;
        Completed = false;
        dateCreated = new Date();
        dateDue = new Date();
    }

    // Default TEST/DEBUG Task object
    public Task(){
        Tname = "TEST_Tname";
        Pname = "TEST_ProjectName";
        Notes = "TEST_Des_Notes";
        Completed = false;
        dateCreated = new Date();
        dateDue = new Date();
    }
}

