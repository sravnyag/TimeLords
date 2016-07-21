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

//    View.OnClickListener listen_project = null;
//    Button project_enter;


    //called when user clicks "ENTER" button
    public void goHSfromProj(View view) {
        final EditText projectName =  (EditText) findViewById(R.id.projectName);
        String projectName1 = projectName.getText().toString();

        //create new project with this name if doesn't already exist
        if (!Gbl.isProject(projectName1)){
            Project newProject = new Project(projectName1);

            //add to all projects Databse
            Gbl.allProjectsDatabase.add(newProject);
        }

        //go to homescreen
        Intent yeedawg = new Intent(this, HomeScreen.class);
        startActivity(yeedawg);

    }

    public String getProjName(){
        return Gbl.passProjName;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getProjName());
        ArrayList<String> projectTasks = new ArrayList<String>();
        int i = Gbl.getPos(Gbl.passProjName);
        int size = Gbl.allProjectsDatabase.get(i).TaskList.size();
        if (Gbl.passProjName.equals("New Project")){
            projectTasks.add("You should add some tasks!");
        }else{
            for (int x=0; x<size; x++){
                projectTasks.add(Gbl.allProjectsDatabase.get(i).TaskList.get(x).getName());
            }
        }
        String [] wtf = new String[size];
        for (int y=0; y<size; y++){
            wtf[0] = "";
        }

        //String[] projectTasks = {"task0", "task1", "task2", "task3"};

        ArrayAdapter<String> myAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projectTasks);

        ListView list_of_tasks=(ListView) findViewById(R.id.project_task_list);

        list_of_tasks.setAdapter(myAdapter);



    }


}
