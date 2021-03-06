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
    public void setProjName(ProjectList proj, String userInput){
        proj.ProjName = userInput;
    }

    // addTask
    // pre: none
    // post: adds task to taskList ArrayList
    // notes:
    public void addTask(ProjectList proj, Task task){
        proj.TaskList.add(task);
    }

    // isProjComplete
    // pre: none
    // post: returns true if project is complete, false otherwise
    public boolean isProjComplete(ProjectList proj){
        return proj.Completed;
    }

    // changeProjComplete
    // pre: none
    // post: if complete, sets to incomplete--if incomplete sets to complete
    // notes: to be used in method to check "done" box on GUI
    public void changeProjComplete (ProjectList proj){
        if (proj.isProjComplete(proj)){
            proj.Completed = false;
        } else {
            proj.Completed = true;
        }
    }

    // hasTask
    // pre: none
    // post: returns true if project has task in
    // notes:
    public boolean hasTask(ProjectList proj, Task task){return proj.TaskList.contains(task);
    }

    public String getProjName(){
        return ProjName;
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
        int zero = 0;
        if (TaskList == null){
            return 0;
        }
        return TaskList.size();
    }

    // getTaskWithName
    // pre: proj task list contains task
    // post:returns task with that name
    // notes:
    public Task getTaskWithName(String name){
        int i = 0;
        while(TaskList.get(i).equals(name)){
            i++;
        }
        return TaskList.get(i);
    }

}
