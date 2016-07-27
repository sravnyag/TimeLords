package com.example.bhouts.taskplanner;

import android.annotation.SuppressLint;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Julia on 7/27/2016.
 */
public class ProjectListUnitTest {

    @Before
    public void createProjectList(){
        ProjectList projectList = new ProjectList();
    }


    // constructor
    @Test
    public void constructor_newProjectList_printFieldValues() {
        ProjectList projectList = new ProjectList();
        assert (projectList.ProjName.equals("All Projects")) :
                "Error: Project name default not correct";
    }

    // setProjName
    @Test
    public void setProjName_stringInput_printField() {
        ProjectList projectList = new ProjectList();
        projectList.setProjName(projectList, "New name");
        assert (projectList.ProjName.equalsIgnoreCase("New name")) :
                "Error: Project name incorrectly set to " + projectList.ProjName;
    }

/*    @Test
    public void setProjName_whitespaceInput_printError() {
        ProjectList projectList = new ProjectList();
        String name1 = "";
        String name2 = " ";
        String name3 = "\t";
        String name4 = "\n";
        Pattern p = Pattern.compile("\\s+");

        projectList.setProjName(name1);
        assert (!p.matcher(projectList.ProjName).matches()) :
                "Error: Project name matches empty string";

        projectList.setProjName(name2);
        assert (!p.matcher(projectList.ProjName).matches()) :
                "Error: Project name matches space character";

        projectList.setProjName(name3);
        assert (!p.matcher(projectList.ProjName).matches()) :
                "Error: Project name matches tab character";

        projectList.setProjName(name4);
        assert (!p.matcher(projectList.ProjName).matches()) :
                "Error: Project name matches newline character";

    }*/

    // addTask
    @SuppressLint("Assert")
    @Test
    public void addTask_taskInput_TaskListContainsTask() {
        ProjectList projectList = new ProjectList();
        Task task = new Task();
        projectList.addTask(projectList,task);
        assert (projectList.TaskList.contains(task)) :
                "Project list does not contain task object";
    }

    // changeProjComplete
    @Test
    public void changeProjComplete_initialChange_printStatus(){
        System.out.println("Testing completion status");

        Project project = new Project("project name");

        System.out.println("Project completion status should be false");
        System.out.println("Project completion status: " + project.Completed);

        project.changeProjComplete(project);
        System.out.println("Project completion status should be true");
        System.out.println("Project completion status: " + project.Completed);

        System.out.println();
    }

    @Test
    public void changeProjComplete_newChange_printStatus(){
        System.out.println("Testing completion status");

        Project project = new Project("project name");

        System.out.println("Project completion status should be false");
        System.out.println("Project completion status: " + project.Completed);

        project.changeProjComplete(project);
        System.out.println("Project completion status should be true");
        System.out.println("Project completion status: " + project.Completed);

        project.changeProjComplete(project);
        System.out.println("Project completion status should be false");
        System.out.println("Project completion status: " + project.Completed);

        System.out.println();
    }

    // hasTask
    @Test
    public void hasTask_containsTask_TaskListContainsTask() {
        ProjectList projectList = new ProjectList();
        Task task = new Task();
        Task task2 = new Task();
        projectList.addTask(projectList, task);
        assert (projectList.hasTask(projectList, task)) :
                "Project list does not contain task object";

        assert (!projectList.hasTask(projectList, task2)) :
                "Project list contains task object that hasn't been added to list";
    }

    // getProjName
    @Test
    public void getProjName_returnName() {
        ProjectList projectList = new ProjectList();
        Task task = new Task();
        assert ( projectList.getProjName().equals("All Projects") ) :
                "Project name field value incorrect";
    }

    // getTaskListSize
    @Test
    public void getTaskListSize_populatedList_correctSize() {
        ProjectList projectList = new ProjectList();
        Task task = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        projectList.addTask(projectList, task);
        projectList.addTask(projectList, task2);
        projectList.addTask(projectList, task3);

        assert ( projectList.getTaskListSize() == 3) :
                "Project List contains three items however size is: " + projectList.getTaskListSize();

    }

}
