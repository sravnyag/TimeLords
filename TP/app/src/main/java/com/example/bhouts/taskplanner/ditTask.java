package com.example.bhouts.taskplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ditTask extends AppCompatActivity {

//    View.OnClickListener listen_task = null;
//    Button task_enter;

    public void completeTask(View view){
        if(!Gbl.passTaskName.equals("New Task")){
            String projName = Gbl.passProjName;
            String taskName = Gbl.passTaskName;
            ProjectList proj = Gbl.getProjWithName(projName);
            Task task = proj.getTaskWithName(taskName);

            task.changeComplete(task);
        }
    }

    public void setHints(){

        CheckBox comp = (CheckBox) findViewById(R.id.checkBox);

        //check if new Task or existing task
        if (Gbl.passTaskName.equals("New Task")) {
            EditText setName = (EditText) findViewById(R.id.taskName);
            setName.setHint("Task:");

            comp.setChecked(false);

            EditText setNotes = (EditText) findViewById(R.id.notes);
            setNotes.setHint("Notes:");

            EditText setDate = (EditText) findViewById(R.id.textDueDate);
            setDate.setHint("Due Date: ");

        }else {
            String projName = Gbl.passProjName;
            String taskName = Gbl.passTaskName;
            ProjectList proj = Gbl.getProjWithName(projName);
            Task task = proj.getTaskWithName(taskName);
            String notes = task.getNotes();
            String date = task.getDueDate();

            EditText setName = (EditText) findViewById(R.id.taskName);
            setName.setHint("Task: " + taskName);

            EditText setNotes = (EditText) findViewById(R.id.notes);
            setNotes.setHint("Notes: " + notes);

            EditText setDate = (EditText) findViewById(R.id.textDueDate);
            setDate.setHint("Due Date: " + date);

//            Spinner projSpin = (Spinner) findViewById(R.id.project_choice);
//            projSpin.

//            //check if task complete attribute is a thing if so do it
            if (task.isComplete(task)) {
                comp.setChecked(true);
            }else{
                comp.setChecked(false);
            }
        }
    }

    //when ENTER button clicked, go to homescreen
    public void enterTask(View view) {
        final EditText taskName = (EditText) findViewById(R.id.taskName);
        String taskName1 = taskName.getText().toString();

        //get the task's notes
        final EditText notes = (EditText) findViewById(R.id.notes);
        String notes1 = notes.getText().toString();

        //get the name of the task's project
        Spinner spinner = (Spinner) findViewById(R.id.project_choice);
        String projectName1 = spinner.getSelectedItem().toString();

        //get the task's notes
        final EditText date = (EditText) findViewById(R.id.textDueDate);
        String date1 = date.getText().toString();

        if (Gbl.passTaskName.equals("New Task")) {
            if (taskName1.equals("")) {
                Toast.makeText(this, "Please enter a Task Name", Toast.LENGTH_SHORT).show();
            }else {
                //get user input:
                //get the name of task

                //create new Task and add attributes from user input
                Task newTask = new Task();
                //if user didnot input a name set the name to "no name"
                if (taskName1.equals(null)) {
                    newTask.setName(newTask, "no name");
                    //else set the name to the user's input
                } else {
                    newTask.setName(newTask, taskName1);
                }
                //set te tasks project name
                newTask.setProject(newTask, projectName1);
                //set the task's notes
                newTask.setNotes(newTask, notes1);
                //set task's dueDate
                newTask.setDueDate(date1);

                //add task to project
                //use gbl method adTaskToProject- checks to see if projects exists, if not creates new project
                Gbl.addTaskToProj(newTask, projectName1);

                //hide fab buttons on homescreen
                Gbl.hide_fab();

                goHome();

                //set priority level
                String priorityStr =
                        ((Spinner) findViewById(R.id.priority_choice)).getSelectedItem().toString();
                newTask.setPriority(priorityStr);

                //check if highly prioritized to add to Urgent project
                if (priorityStr.equals("High")) {
                    Gbl.urgent.addTask(Gbl.urgent, newTask);
                }

                goHome();
            }

        //else tak already exists and should edit, not create new
        }else{
            Task task = Gbl.getProjWithName(Gbl.passProjName).getTaskWithName(Gbl.passTaskName);
            //if user edited text fields, change tasks attributes
            if (!taskName1.equals("")){
                task.setName(taskName1);
            }
            if (!notes1.equals("")){
                task.setNotes(task, notes1);
            }
            if (!date1.equals("")){
                task.setDueDate(date1);
            }
            task.setProject(task,projectName1);

            //go to task's project page
            goHome();
        }
    }

    private Spinner priority;
    private Spinner tag;

    // dynamically set spinner elements
    public void populatePrioritySpinner(Spinner project_spinner,
                                        Spinner priority_spinner,
                                        Spinner tag_spinner) {
        ArrayAdapter<String> priorityAdapter =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, Gbl.priority_levels);
        priorityAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        priority_spinner.setAdapter(priorityAdapter);

        ArrayAdapter<String> tagAdapter =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, Gbl.tags);
        tagAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        tag_spinner.setAdapter(tagAdapter);

        ArrayAdapter<String> projectAdapter =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, Gbl.list_of_projects);
        projectAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        project_spinner.setAdapter(projectAdapter);
    }

    public void goHome(){
        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);
    }

    public void goProject(){
        Intent goProj = new Intent(this, editProject.class);
        startActivity(goProj);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Gbl.passTaskName);

        // set spinners
        Spinner project = (Spinner) findViewById(R.id.project_choice);
        Spinner priority = (Spinner) findViewById(R.id.priority_choice);
        Spinner tag = (Spinner) findViewById(R.id.tag_choice);
        populatePrioritySpinner(project, priority, tag);

        setHints();
    }
}