package com.example.bhouts.taskplanner;

import java.util.Date;

import javax.xml.datatype.Duration;

/**
 * ProjectListInterface.java
 * interface for the ProjectList and Project objects
 * Created by Brian on 7/16/2016.
 */
public interface ProjectListInterface {

    // setProjName
    // pre: none
    // post: adds name to initially empty Tname attribute in a task obj
    // notes:
    public abstract void setProjName(ProjectList proj, String userInput);

    // addTask
    // pre: none
    // post: adds task to taskList ArrayList
    // notes:
    public abstract void addTask(ProjectList proj, Task task);

    // isProjComplete
    // pre: none
    // post: returns true if project is complete, false otherwise
    public abstract boolean isProjComplete(ProjectList proj);

    // changeProjComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public abstract void changeProjComplete(ProjectList proj);

    // hasTask
    // pre: none
    // post: returns true if project has task in
    // notes:
    public abstract boolean hasTask(ProjectList proj, Task task);

    // getProjName
    // pre: none
    // post: returns true if project has task in
    // notes:
    public abstract String getProjName();

    // getTaskList
    // pre: none
    // post:
    // notes:
    public abstract String[] getTaskList();

    // getTaskListSize
    // pre: none
    // post:
    // notes:
    public abstract int getTaskListSize();

    // getTaskWithName
    // pre: none
    // post:returns tsk with the name from project's tasklist
    // notes:
    public abstract Task getTaskWithName(String name);

}
