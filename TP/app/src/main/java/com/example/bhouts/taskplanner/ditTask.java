package com.example.bhouts.taskplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ditTask extends AppCompatActivity {

//    View.OnClickListener listen_task = null;
//    Button task_enter;

    //when ENTER button clicked, go to homescreen
    public void goHSfromTask(View view) {
        //get user input:
        //get the name of task
        final EditText taskName =  (EditText) findViewById(R.id.taskName);
        String taskName1 = taskName.getText().toString();


        //get the name of the task's project
        /*final EditText projectName =  (EditText) findViewById(R.id
                .projectAttName);
        String projectName1 = projectName.getText().toString();*/
        Spinner spinner = (Spinner)findViewById(R.id.project_choice);
        String projectName1  = spinner.getSelectedItem().toString();

        //get the task's notes
        final EditText notes =  (EditText) findViewById(R.id.notes);
        String notes1 = notes.getText().toString();

        //create new Task and add attributes from user input
        Task newTask = new Task();
        //if user didnot input a name set the name to "no name"
        if (taskName1.equals(null)){
            newTask.setName(newTask, "no name");
        //else set the name to the user's input
        }else{
            newTask.setName(newTask, taskName1);
        }
        //set te tasks project name
        newTask.setProject(newTask, projectName1);
        //set the task's notes
        newTask.setNotes(newTask, notes1);

        //add task to project
        //use gbl method adTaskToProject- checks to see if projects exists, if not creates new project
        Gbl.addTaskToProj(newTask, projectName1);

        //hide fab buttons on homescreen
        Gbl.hide_fab();

        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);

        // pottentially need to get rid of null pointer error
//        newTask.setName(((taskName.equals(null)) ? "no_name" :
//                taskName1));

        //set DueDate;
        try {
            DateFormat format =
                    new SimpleDateFormat("MM/dd/yyyy");
            String DueDateStr =
                    ((EditText) findViewById(R.id.textDueDate))
                            .getText().toString();
            newTask.setDueDate(format.parse(DueDateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //set priorit level
        String priorityStr =
                ((EditText) findViewById(R.id.notes))
                        .getText().toString();
        newTask.setPriority(((priorityStr.equals(null)) ?
                "no_name" :
                priorityStr));

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // set spinners
        Spinner project = (Spinner) findViewById(R.id.project_choice);
        Spinner priority = (Spinner) findViewById(R.id.priority_choice);
        Spinner tag = (Spinner) findViewById(R.id.tag_choice);
        populatePrioritySpinner(project, priority, tag);
    }
}