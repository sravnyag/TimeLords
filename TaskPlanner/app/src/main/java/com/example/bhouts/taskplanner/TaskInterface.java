package com.example.bhouts.taskplanner;

import java.util.Date;

import javax.xml.datatype.Duration;

/**
 * TaskInterface.java
 * interface for the Task object
 * Created by Julia on 7/15/2016.
 */
public interface TaskInterface {

    // setName
    // pre: none
    // post: adds name to initially empty Tname attribute in a task obj
    // notes:
    public void setName(Task task, String userInput);

    // setNotes
    // pre: none
    // post: adds notes to initially empty notes attribute in a task obj
    // notes: edit so you can edit notes not just set notes
    public void setNotes(Task task, String userInput);

    // setProject
    // pre: none
    // post: sets Project for a given task obj
    // notes: create check for existing project-if project DNE call create new project method
    public void setProject(Task task, String userInput);

    // setDueDate
    // pre: none
    // post: sets DueDate attribute for a task obj
    public void setDueDate(Task task, Date userInput);

    // setDuration
    // pre: none
    // post: sets Duration for a task obj
    public void setDuration(Task task, Duration userInput);

    // setPriority
    // pre: none
    // post: sets priority for a task obj
    public void setPriority(Task task, String userInput);

    // editTags
    // pre: none
    // post: adds tags to task obj
    // notes: allow for deletion of tags
    public void editTags(Task task, String userInput);

    // isComplete
    // pre: none
    // post: returns true if task is complete, false otherwise
    public boolean isComplete(Task task);

    // changeComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public void changeComplete (Task task);
}
