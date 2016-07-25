package com.example.bhouts.taskplanner;
import java.util.ArrayList;

/**
 * Created by bhouts on 7/10/2016.
 */
public class ProjectList implements ProjectListInterface{
    public String ProjName;
    public Boolean Completed;
    public ArrayList<Task> TaskList = new ArrayList<Task>();


    //constructor
    public ProjectList(){
        ProjName = "All Projects";
        Completed = false;

    }

    // setProjName
    // pre: none
    // post: adds name to initially empty Tname attribute in a task obj
    // notes:
    public void setProjName(String userInput){
        this.ProjName = userInput;
    }

    // addTask
    // pre: none
    // post: adds task to taskList ArrayList
    // notes:
    public void addTask(Task task){
        this.TaskList.add(task);
    }

    // isProjComplete
    // pre: none
    // post: returns true if project is complete, false otherwise
    public boolean isProjComplete(){
        return this.Completed;
    }

    // changeProjComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public void changeProjComplete (){
        if (this.isProjComplete()){
            this.Completed = false;
        } else {
            this.Completed = true;
        }
    }

    // hasTask
    // pre: none
    // post: returns true if project has task in
    // notes:
    public boolean hasTask(Task task){return this.TaskList.contains(task);
    }

    public String getProjName(){
        return this.ProjName;
    }

    // getTaskList
    // pre: none
    // post:
    // notes:
    public String[] getTaskList(){
        int size = TaskList.size();
        String[] yo = new String[size];
        for (int i = 0; i < size; i++) {
            yo[i] = TaskList.get(i).getName();
        }
        return yo;
    }

    // getTaskListSize
    // pre: none
    // post:
    // notes:
    public int getTaskListSize(){
        return TaskList.size();
    }


    // isProject
    // pre: none
    // post: returns true if project exists
    //       else returns false
    public boolean isProject(String projectName) {
        // search project list by pname
        // if found return true
        // else return false
        return true;
    }

    // getProject
    // pre: isProject != null
    // post: returns project
    // throws: projectDoesNotExist
    public Project getProject (String projectName) {
        // search project list by pname
        // if found return project
        // else throw exception
        return new Project(projectName);
    }

    // newProject
    // pre: none
    // post: creates project and adds to projList
    public Project newProject(String projectName) {
        Project newProject = new Project(projectName);
        Gbl.projList.addProject(newProject);
        return new Project(projectName);
    }

    // addProject
    // pre: none
    // post: adds project to projList
    private Project addProject(Project project) {

        return project;
    }


    // getTaskWithName
    // pre: TaskList is non-empty
    // post:returns tsk with the name from project's tasklist
    // notes:
    public Task getTaskWithName(String name){
        int size = getTaskListSize();
        for (int i=0;i<size;i++){
            if (TaskList.get(i).getName().equals(name)){
                return TaskList.get(i);
            }
        }
        return TaskList.get(0);
    }


}
