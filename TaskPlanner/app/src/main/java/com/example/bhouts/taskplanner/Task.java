package com.example.bhouts.taskplanner;
import java.util.*;
import java.lang.Object;

import javax.xml.datatype.Duration;

/**
 * Task.java
 * Created by bhouts on 7/10/2016.
 */


public class Task implements TaskInterface{

    // private inner Priority class
    private class Priority {
        String priority;

        // constructor
        private Priority (String input){
            priority = input;
            if (!priority.equalsIgnoreCase("high") | !priority.equalsIgnoreCase("med") |
                    !priority.equalsIgnoreCase("low") | !priority.equalsIgnoreCase("none")){
                System.err.println("Incorrect priority input");
            }
        }
    }


    // private inner Tags class
    private class Tags {
        String tagString;
        List<String> tags;
        int numItems;

        // constructor
        private Tags (){
            List<String> tags= new ArrayList<String>(0);
            int numItems = tags.size();
        }
    }

    // fields for the Task class
    public String Tname;         //task name
    public String Pname;	     //associated poject
    public String Notes;         //task description
    public Boolean Completed;
    public Priority priority;
    public Duration duration;
    public Tags tagList;
    public Date dateCreated;
    public Date dateDue;


    // private helper functions --------------------------------------------------------------------

    // addTag
    // pre: none
    // post: if tagList null creates new tagList
    //       appends string to tagList
    private void addTag(Tags tagList, String tagToken){
        //append to existing arrayList
        if ( tagList == null ){
            tagList = new Tags();
        }
        tagList.tags.add(tagToken);
    }

    // splitTags
    // pre: String != null
    // post: returns Tags object with all userInput tags appended
    private Tags splitTags( Tags tagList, String userInput ){
        StringTokenizer tokenizer = new StringTokenizer(userInput, "\\s+,");
        while ( tokenizer.hasMoreTokens() ){
            addTag( tagList, tokenizer.nextToken());
        }
        return tagList;
    }

    // isEmpty
    // pre: none
    // post: returns true if tag list is empty
    private boolean isEmpty(Task task){
        return ( task.tagList.numItems == 0 );
    }


    // Task ADT operations--------------------------------------------------------------------------

    //constructor
    public Task(){
        Tname = null;
        Pname = "Dump";
        Notes = null;
        Completed = false;
        priority = null;
        duration = null;
        tagList = null;
        dateDue = null;
    }

    // setName - this
    // pre: none
    // post: sets name to initially empty Tname attribute in a task obj
    public void setName(String userInput) {this.Tname = userInput; }

    // setName
    // pre: none
    // post: sets name to initially empty Tname attribute in a task obj
    public void setName(Task task, String userInput) {task.Tname = userInput; }

    // setNotes
    // pre: none
    // post: adds notes to initially empty notes attribute in a task obj
    // notes: edit so you can edit notes not just set notes
    public void setNotes(Task task, String userInput){
        task.Notes = userInput;
    }

    // setProject
    // pre: none
    // post: sets Project for a given task obj
    // notes: create check for existing project-if project DNE call create new project method
    public void setProject(Task task, String userInput){
        task.Pname = userInput;
    }

    // setDueDate - this
    // pre: none
    // post: sets DueDate attribute for a task obj
    public void setDueDate(Date userInput){
        this.dateDue = userInput;
    }

    // setDueDate
    // pre: none
    // post: sets DueDate attribute for a task obj
    public void setDueDate(Task task, Date userInput){
        task.dateDue = userInput;
    }

    // setDuration
    // pre: none
    // post: sets Duration for a task obj
    public void setDuration(Task task, Duration userInput){
        task.duration = userInput;
    }

    // setPriority - this
    // pre: none
    // post: sets priority for a task obj
    public void setPriority(String userInput){
        Priority p = new Priority (userInput);
        this.priority = p;
    }

    // setPriority
    // pre: none
    // post: sets priority for a task obj
    public void setPriority(Task task, String userInput){
        Priority p = new Priority (userInput);
        task.priority = p;
    }

    // editTags
    // pre: none
    // post: adds tags to task obj
    // notes: allow for deletion of tags
    public void editTags(Task task, String userInput) {

        if (userInput != null) {
            splitTags(task.tagList, userInput);
        } else {
            System.err.println("User Input may not be null");
        }
    }

    // isComplete
    // pre: none
    // post: returns true if task is complete, false otherwise
    public boolean isComplete (Task task){
        return task.Completed;
    }

    // changeComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public void changeComplete (Task task){
        if (isComplete(task)){
            task.Completed = false;
        } else {
            task.Completed = true;
        }
    }

    // getName
    // pre: none
    // post:
    // notes:
    public String getName(){
        return Tname;
    }

    // getProName
    // pre: none
    // post:
    // notes:
    public String getProName(){
        return Pname;
    }

    // getNotes
    // pre: none
    // post:
    // notes:
    public String getNotes(){
        return Notes;
    }

    // getComp
    // pre: none
    // post:
    // notes:
    public boolean getComp(){
        return Completed;
    }

    // getDueDate
    // pre: none
    // post:
    // notes:
    public Date getDueDate(){
        return dateDue;
    }

}