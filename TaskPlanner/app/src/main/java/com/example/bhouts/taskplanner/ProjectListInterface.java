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
    void setProjName(String userInput);

    // addTask
    // pre: none
    // post: adds task to taskList ArrayList
    // notes:
    void addTask(Task task);

    // isProjComplete
    // pre: none
    // post: returns true if project is complete, false otherwise
    boolean isProjComplete();

    // changeProjComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    void changeProjComplete();

    // hasTask
    // pre: none
    // post: returns true if project has task in
    // notes:
    boolean hasTask(Task task);

    // getProjName
    // pre: none
    // post: returns true if project has task in
    // notes:
    String getProjName();

    // getTaskList
    // pre: none
    // post:
    // notes:
    String[] getTaskList();

    // getTaskListSize
    // pre: none
    // post:
    // notes:
    public int getTaskListSize();

    // isProject
    // pre: none
    // post: returns true if project exists
    //       else returns false
    public boolean isProject(String projectName);

    // getProject
    // pre: isProject != null
    // post: returns project
    // throws: projectDoesNotExist
    public Project getProject (String projectName);

    // newProject
    // pre: none
    // post: creates project and adds to projList
    public Project newProject(String projectName);

}
