package com.example.bhouts.taskplanner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Date;
import java.util.regex.Pattern;

import javax.xml.datatype.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Julia on 7/15/2016.
 */

public class TaskUnitTest {


    @Test
    public void constructor_uninitializedTask () {
        Task task1 = new Task();


        System.out.println("Task name is: " + task1.Tname);

        System.out.println("Project name is: " + task1.Pname);

        System.out.print("Notes == null : ");
        if ( task1.Notes == null ) {
            System.out.println("true");
        }
        else System.out.println("false");

        System.out.println("Task completed: " + task1.Completed);

        System.out.print("priority == none : ");
        if ( task1.priority == null ) {
            System.out.println("true");
        }
        else System.out.println("false");

        System.out.print("duration == null : ");
        if ( task1.duration == null ) {
            System.out.println("true");
        }
        else System.out.println("false");

        System.out.print("tagList == null : ");
        if ( task1.tagList == null ) {
            System.out.println("true");
        }
        else System.out.println("false");

        System.out.print("dateDue == null : ");
        if ( task1.dateDue == null ) {
            System.out.println("true");
        }
        else System.out.println("false");
    }

    @Test
    public void setName_nullInput_printNewTask(){
        System.out.println("testing null input for task name");

        Task task1 = new Task();
        String nullString = null;
        task1.setName(nullString);

        System.out.println("Task name is: " + task1.Tname);
        System.out.println();
    }

    @Test
    public void setName_whitespaceInput_printNewTask(){
        System.out.println("Testing whitespace input for task name");

        Task task1 = new Task();
        String whiteSpace1 = " ";
        String whiteSpace2 = "";
        String whiteSpace3 = "\n";
        String whiteSpace4 = "\r";
        String whiteSpace5 = "\t";

        task1.setName(whiteSpace1);
        System.out.println("Task name is: " + task1.Tname);

        task1.setName(whiteSpace2);
        System.out.println("Task name is: " + task1.Tname);

        task1.setName(whiteSpace3);
        System.out.println("Task name is: " + task1.Tname);

        task1.setName(whiteSpace4);
        System.out.println("Task name is: " + task1.Tname);

        task1.setName(whiteSpace5);
        System.out.println("Task name is: " + task1.Tname);

        System.out.println();

    }

    @Test
    public void setName_stringInput_printInput(){
        System.out.println("Testing string input for task name");

        Task task1 = new Task();
        String string1 = "Hello";
        String string2 = "Hello again";

        task1.setName(string1);
        System.out.println("Task name is: " + task1.Tname);

        task1.setName(string2);
        System.out.println("Task name is now: " + task1.Tname);

        System.out.println();
    }

    @Test
    public void setNotes_stringInput_printInput(){
        System.out.println("Testing string input for notes");

        Task task1 = new Task();
        String string1 = "These are my notes";
        String string2 = "Now these are my notes";

        task1.setNotes(string1);
        System.out.println("Task notes are: " + task1.Notes);

        task1.setNotes(string2);
        System.out.println("Task notes are: " + task1.Notes);

        System.out.println();
    }

    @Test
    public void setProject_stringInput_printInput(){
        System.out.println("Testing string input for project name");

        Task task1 = new Task();
        String string1 = "Project 1";
        String string2 = "Project 2";

        System.out.println("Project name is initially: " + task1.Pname);
        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(string2);
        System.out.println("Project is now: " + task1.Pname);

        System.out.println();

    }

    @Test
    public void setProject_stringInputThenBlankInput_printDefaultProject(){
        System.out.println("Testing string input for project name");

        Task task1 = new Task();
        String string1 = "Project 1";
        String whiteSpace1 = " ";
        String whiteSpace2 = "";
        String whiteSpace3 = "\n";
        String whiteSpace4 = "\r";
        String whiteSpace5 = "\t";

        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(whiteSpace1);
        System.out.println("Project is now: " + task1.Pname);

        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(whiteSpace2);
        System.out.println("Project is now: " + task1.Pname);

        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(whiteSpace3);
        System.out.println("Project is now: " + task1.Pname);

        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(whiteSpace4);
        System.out.println("Project is now: " + task1.Pname);

        task1.setProject(string1);
        System.out.println("Project is: " + task1.Pname);

        task1.setProject(whiteSpace5);
        System.out.println("Project is now: " + task1.Pname);

        System.out.println();

    }

    @Test
    public void setDueDate_newDueDate_printDueDate(){
        System.out.println("Testing initial due date");

        Task task1 = new Task();
        Date newDate = new Date(2016, 8, 24);

        task1.setDueDate(newDate);

        System.out.println("Input is: 8/24/2016");
        System.out.println("Task Due Date is: " + task1.dateDue);

        System.out.println();
    }

    @Test
    public void setDueDate_changeDueDate_printNewDueDate(){
        System.out.println("Testing changed due date");

        Task task1 = new Task();
        Date newDate1 = new Date(2016, 8, 24);
        Date newDate2 = new Date(2017, 5, 3);

        task1.setDueDate(newDate1);

        System.out.println("Input is: 8/24/2016");
        System.out.println("Task Due Date is: " + task1.dateDue);

        task1.setDueDate(newDate2);

        System.out.println("Input is: 5/3/2017");
        System.out.println("Task Due Date is: " + task1.dateDue);

        System.out.println();
    }

/*    @Test
    public void setDueDate_pastDueDate_printError(){

    }

    @Test
    public void setDuration_newDuration_printDuration(){
        System.out.println("Testing new duration");

        Task task1 = new Task();
    }

    @Test
    public void setDuration_changeDuration_printDuration(){

    }*/

    @Test
    public void changeComplete_initialChange_printStatus(){
        System.out.println("Testing completion status");

        Task task1 = new Task();

        System.out.println("Task completion status should be false");
        System.out.println("Task completion status: " + task1.Completed);

        task1.changeComplete();
        System.out.println("Task completion status should be true");
        System.out.println("Task completion status: " + task1.Completed);

        System.out.println();
    }

    @Test
    public void changeComplete_newChange_printStatus(){
        System.out.println("Testing completion status");

        Task task1 = new Task();

        System.out.println("Task completion status should be false");
        System.out.println("Task completion status: " + task1.Completed);

        task1.changeComplete();
        System.out.println("Task completion status should be true");
        System.out.println("Task completion status: " + task1.Completed);

        task1.changeComplete();
        System.out.println("Task completion status should be false");
        System.out.println("Task completion status: " + task1.Completed);

        System.out.println();
    }

    @Test
    public void setPriority_initialPriorityChange_printPriorityStatus(){
        System.out.println("Testing initial priority change");

        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        String string1 = "low";
        String string2 = "med";
        String string3 = "high";

        System.out.println("Task one initial priority is: " + task1.priority);
        System.out.println("Changing to low priority");
        task1.setPriority(string1);
        System.out.println("Priority is now: " + task1.priority);


        System.out.println("Task two initial priority is: " + task2.priority);
        System.out.println("Changing to med priority");
        task2.setPriority(string2);
        System.out.println("Priority is now: " + task2.priority);


        System.out.println("Task three initial priority is: " + task3.priority);
        System.out.println("Changing to high priority");
        task3.setPriority(string3);
        System.out.println("Priority is now: " + task3.priority);


        System.out.println();

    }

    @Test
    public void setPriority_changePriorityAllCombinations_printPriorityStatus(){
        System.out.println("Testing all combinations of changing priority levels");

        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        String string1 = "low";
        String string2 = "med";
        String string3 = "high";
        String string4 = "none";

        task1.setPriority(string1);
        task2.setPriority(string2);
        task3.setPriority(string3);

        Task[] tasks = {task1, task2, task3};
        String[] priorities = {string1, string2, string3, string4};

        for ( int i=0; i < tasks.length; i++ ){
            System.out.println("Initial priority is: " + tasks[i].priority);
            for (int j=0; j < priorities.length; j++){
                System.out.println("Changing priority to: " + priorities[j]);
                tasks[i].setPriority(priorities[j]);
                if ( j==0 && "low".equals(tasks[i].priority) ) {
                    System.out.println("Priority successfully changed");
                }
                else {
                    System.out.println("Priority change failed");
                }
                if ( j==1 && "med".equals(tasks[i].priority) ) {
                    System.out.println("Priority successfully changed");
                }
                else {
                    System.out.println("Priority change failed");
                }
                if ( j==2 && "high".equals(tasks[i].priority) ) {
                    System.out.println("Priority successfully changed");
                }
                else {
                    System.out.println("Priority change failed");
                }
                if ( j==3 && "none".equals(tasks[i].priority) ) {
                    System.out.println("Priority successfully changed");
                }
                else {
                    System.out.println("Priority change failed");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    @Test
    public void setPriority_changePriorityAllCombinationsBadInput_printError(){
        System.out.println("Testing bad input for setting priority");

        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        Task task4 = new Task();

        String string1 = "bad input";
        task1.setPriority("low");
        task2.setPriority("med");
        task3.setPriority("high");

        Task[] tasks = {task1, task2, task3, task4};

        for( int i=0; i<tasks.length; i++ ){
            System.out.println("Initial priority is: " + tasks[i].priority);
            tasks[i].setPriority(string1);
            System.out.println("Priority is now: " + tasks[i].priority);
        }
        System.out.println();
    }



}
