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
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class editTask extends AppCompatActivity {

//    View.OnClickListener listen_task = null;
//    Button task_enter;

    //when ENTER button clicked, go to homescreen
    public void goHSfromTask(View view) {
        //get user input:
        //get the name of task
        final EditText taskName =  (EditText) findViewById(R.id.taskName);
        String taskName1 = taskName.getText().toString();

        //get the name of the task's project
        final EditText projectName =  (EditText) findViewById(R.id.projectAttName);
        String projectName1 = projectName.getText().toString();

        //get the task's notes
        final EditText notes =  (EditText) findViewById(R.id.notes);
        String notes1 = notes.getText().toString();

        //create new Task and add attributes from user input
        Task newTask = new Task();
        //if user didnot input a name set the name to "no name"
        if (taskName1.equals(null)){
            newTask.setName("no name");
        //else set the name to the user's input
        }else{
            newTask.setName(taskName1);
        }
        newTask.setProject(projectName1);
        newTask.setNotes(notes1);
        //set te tasks project name
        newTask.setProject(projectName1);
        //set the task's notes
        newTask.setNotes(notes1);

        //add task to project
        //use gbl method adTaskToProject- checks to see if projects exists, if not creates new project
        Gbl.addTaskToProj(newTask, projectName1);

        //set DueDate;
        try {
            DateFormat format =
                    new SimpleDateFormat("MM/dd/yyyy");
            String DueDateStr =
                    ((EditText) findViewById(R.id.textDueDate))
                            .getText().toString();
            Date temp = format.parse(DueDateStr);
            if (temp.toString()!=null){
                newTask.setDueDate(temp);
            }else{
                temp = format.parse("01/01/01");
                newTask.setDueDate(temp);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //set priorit level
        String priorityStr =
                ((EditText) findViewById(R.id.notes))
                        .getText().toString();
        newTask.setPriority(((priorityStr.equals(null)) ?
                "none" :
                priorityStr));

        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);

    }

    public void setHints(){//if simply ceating new task, reqular hints
        if (Gbl.passTaskName.equals("New Task")){
            ((TextView) findViewById(R.id.taskName)).setHint("Task:");
            ((TextView) findViewById(R.id.projectAttName)).setHint("Project:");
            ((TextView) findViewById(R.id.notes)).setHint("Notes:");
            ((TextView) findViewById(R.id.textDueDate)).setHint("Due Date:");
            //else the hint fields will display the task's attributes
        }else{
            ((TextView) findViewById(R.id.taskName)).setHint("Task: " + Gbl.passTaskName);
            ((TextView) findViewById(R.id.projectAttName)).setHint("Project: " + Gbl.passProjName);
            String notes = Gbl.getProjWithName(Gbl.passProjName).getTaskWithName(Gbl.passTaskName).getNotes();
            String date = Gbl.getProjWithName(Gbl.passProjName).getTaskWithName(Gbl.passTaskName).getDueDate().toString();
            ((TextView) findViewById(R.id.notes)).setHint("Notes: " + notes);
            ((TextView) findViewById(R.id.textDueDate)).setHint("Due Date:" + date);
        }
    }

    private Spinner priority;
    private Spinner tag;

    // dynamically set spinner elements
    public void populatePrioritySpinner(Spinner spinner1,
                                        Spinner spinner2) {
        List<String> priority_list = new ArrayList<String>();
        priority_list.add("High");
        priority_list.add("Med");
        priority_list.add("Low");
        ArrayAdapter<String> dataAdapter1 =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, priority_list);
        dataAdapter1.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);

        List<String> tag_list = new ArrayList<String>();
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
        ArrayAdapter<String> dataAdapter2 =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, tag_list);
        dataAdapter2.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }

    //method to resolve the name of the header
    public String getTaskName(){
        return Gbl.passTaskName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getTaskName());

        setHints();
        populatePrioritySpinner(
                (Spinner) findViewById(R.id.priority_choice),
                (Spinner) findViewById(R.id.tag_choice)
        );

    }
}