package com.example.bhouts.taskplanner;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.Duration;

/**
 * Task.java
 * Created by bhouts on 7/10/2016.
 */


public class Task implements TaskInterface{
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
    public String priority;
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
        Tname = "New Task";
        Pname = "Dump";
        Notes = null;
        Completed = false;
        priority = "none";
        duration = null;
        tagList = null;
        dateDue = null;
    }

    // setName
    // pre: none
    // post: changes Tname field
    public void setName(String userInput){
        if ( utils.isValidInput(userInput) ){
            Pattern p = Pattern.compile("\\s+");
            Matcher m = p.matcher(userInput);
            boolean b = m.matches();
            if (!b) {
                this.Tname = userInput;
            }
        }
    }


    // setNotes
    // pre: none
    // post: adds notes to initially empty notes attribute in a task obj
    // notes: edit so you can edit notes not just set notes
    public void setNotes(String userInput){
        if ( utils.isValidInput(userInput) ) {
            this.Notes = userInput;
        }
    }

    // setProject
    // pre: none
    // post: sets Project for a given task obj
    // notes: checks for existing project-if project DNE call create new project method
    //        if user sets to whitespace or null then go back to default project
    public void setProject(String projectName){
        if ( utils.isValidInput(projectName) ) {
            this.Pname = projectName;
        }
        else {
            projectName = this.Pname;
        }
        if ( !Gbl.projList.isProject(projectName) ) {
            Gbl.projList.newProject(projectName);
        }
        Project project = Gbl.projList.getProject(projectName);
        project.addTask(this);
    }

    // setDueDate - this
    // pre: none
    // post: sets DueDate attribute for a task obj
    public void setDueDate(Date userInput){
        this.dateDue = userInput;
    }

    // setDuration
    // pre: none
    // post: sets Duration for a task obj
/*    public void setDuration(Duration userInput){
        this.duration = userInput;
    }*/

    // setPriority
    // pre: none
    // post: sets priority for a task obj
    public void setPriority(String userInput){
        switch (userInput) {
            case "high": this.priority = "high";
                break;
            case "med": this.priority = "med";
                break;
            case "low": this.priority = "low";
                break;
            case "none": this.priority = "none";
                break;
            default: System.err.println("Incorrect priority input");
                break;
        }
    }

    // editTags
    // pre: none
    // post: adds tags to task obj
    // notes: allow for deletion of tags
    public void editTags(String userInput){
        if ( userInput != null ) splitTags(this.tagList, userInput);
        else System.err.println("User Input may not be null");
    }

    // isComplete
    // pre: none
    // post: returns true if task is complete, false otherwise
    public boolean isComplete (){
        return this.Completed;
    }

    // changeComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public void changeComplete (){
        this.Completed = !this.isComplete();

    }

    // getName
    // pre: none
    // post:
    // notes:
    public String getName(){
        return this.Tname;
    }

    // getProName
    // pre: none
    // post:
    // notes:
    public String getProName(){
        return this.Pname;
    }

    // getNotes
    // pre: none
    // post:
    // notes:
    public String getNotes(){
        return this.Notes;
    }

    // getComp
    // pre: none
    // post:
    // notes:
    public boolean getComp(){
        return this.Completed;
    }

    // getDueDate
    // pre: none
    // post:
    // notes:
    public Date getDueDate(){
        return this.dateDue;
    }


    public String printPriority() {
        return this.priority.toString();
    }





}