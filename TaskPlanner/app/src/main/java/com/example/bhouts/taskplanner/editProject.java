package com.example.bhouts.taskplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class editProject extends  AppCompatActivity {

//    View.OnClickListener listen_project = null;
//    Button project_enter;


    //called when user clicks "ENTER" button
    public void goHSfromProj(View view) {
        final EditText projectName =  (EditText) findViewById(R.id.projectName);
        String projectName1 = projectName.getText().toString();

        Project newProject = new Project();
        newProject.setProjName(newProject, projectName1);
        //add to all projects Databse
        Gbl.allProjectsDatabase.add(newProject);

        //go to homescreen
        Intent yeedawg = new Intent(this, HomeScreen.class);
        startActivity(yeedawg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] projectTasks = {"task0", "task1", "task2", "task3"};

        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projectTasks);

        ListView list_of_tasks=(ListView) findViewById(R.id.project_task_list);

        list_of_tasks.setAdapter(myAdapter);


//        project_enter = (Button) findViewById(R.id.project_enter);
//
//        //when task_done button pushed, creates new Task instance
//        listen_project = new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                final EditText projectName =  (EditText) findViewById(R.id.projectName);
//                String projectName1 = projectName.getText().toString();
//
//                Project newProject = new Project();
//                newProject.setProjName(newProject, projectName1);
//                //add to all projects Databse
//                Gbl.allProjectsDatabase.add(newProject);
//
//            }
//        };
//        project_enter.setOnClickListener(listen_project);

    }

}
