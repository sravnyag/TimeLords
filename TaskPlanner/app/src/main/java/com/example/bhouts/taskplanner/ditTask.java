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

public class ditTask extends AppCompatActivity {

//    View.OnClickListener listen_task = null;
//    Button task_enter;

    //when ENTER button clicked, go to homescreen
    public void goHSfromTask(View view) {
        //get user input
        final EditText taskName =  (EditText) findViewById(R.id.taskName);
        String taskName1 = taskName.getText().toString();

        final EditText projectName =  (EditText) findViewById(R.id.projectAttName);
        String projectName1 = projectName.getText().toString();


        final EditText notes =  (EditText) findViewById(R.id.notes);
        String notes1 = notes.getText().toString();

        //create new Task and add attributes from user input
        Task newTask = new Task();
        newTask.setName(newTask, taskName1);
        newTask.setProject(newTask, projectName1);
        newTask.setNotes(newTask, notes1);
        Intent ilikeboobies = new Intent(this, HomeScreen.class);
        startActivity(ilikeboobies);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        task_enter = (Button) findViewById(R.id.task_enter);

//        //when task_done button pushed, creates new Task instance
//        listen_task = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                //get user input
//                final EditText taskName =  (EditText) findViewById(R.id.taskName);
//                String taskName1 = taskName.getText().toString();
//
//                final EditText projectName =  (EditText) findViewById(R.id.projectAttName);
//                String projectName1 = projectName.getText().toString();
//
//
//                final EditText notes =  (EditText) findViewById(R.id.notes);
//                String notes1 = notes.getText().toString();
//
//                //create new Task and add attributes from user input
//                Task newTask = new Task();
//                newTask.setName(newTask, taskName1);
//                newTask.setProject(newTask, projectName1);
//                newTask.setNotes(newTask, notes1);
//
//
//            }
//        };
//        task_enter.setOnClickListener(listen_task);

    }

}
