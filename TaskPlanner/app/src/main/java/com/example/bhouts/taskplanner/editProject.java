package com.example.bhouts.taskplanner;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class editProject extends AppCompatActivity {



    //called when user clicks "ENTER" button
    public void goHSfromProj(View view) {
        final EditText projectName =  (EditText) findViewById(R.id.projectName);
        String projectName1 = projectName.getText().toString();

        //create new project with this name if doesn't already exist
        if (!Gbl.isProject(projectName1)){
            Project newProject = new Project(projectName1);

            //add to all projects Database
            Gbl.allProjectsDatabase.add(newProject);
        }

        //go to homescreen
        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);

    }

    public String getProjName(){
        return Gbl.passProjName;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);
        //set page name
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getProjName());

        //get string array of tasks
        //get project position
        int i = Gbl.getPos(Gbl.passProjName);
        //find size of project's task list
        int size;
        //check to see if the click to get to project page was from the project list or from the new project fab
        if (!Gbl.passProjName.equals("New Project")){
            size = Gbl.allProjectsDatabase.get(i).getTaskListSize();
        }else{
            size = 1;
        }
        String[] taskList = new String[size];
        if (!Gbl.passProjName.equals("New Project")){
            taskList = Gbl.allProjectsDatabase.get(i).getTaskList();
        }else{
            taskList[0] = "";
        }

        //set the list of tasks for the project page
        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList);

        ListView list_of_tasks=(ListView) findViewById(R.id.project_task_list);

        list_of_tasks.setAdapter(myAdapter);



    }


}
