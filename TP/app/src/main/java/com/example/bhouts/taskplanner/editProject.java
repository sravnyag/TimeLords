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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class editProject extends  AppCompatActivity {

    /*called when task list item is pushed*/
    public void goTask(View view) {
        Intent go_ditTask = new Intent(this, ditTask.class);
        startActivity(go_ditTask);
    }

    //called when user clicks "ENTER" button
    public void projEnter(View view) {
        final EditText projectName = (EditText) findViewById(R.id.projectName);
        String projectName1 = projectName.getText().toString();

        //check if creating new project or editing existing
        if (Gbl.passProjName.equals("New Project")) {
            //make sure user entered something
            if (projectName1.equals("")) {
                Toast.makeText(this, "Please enter a Project", Toast.LENGTH_SHORT).show();
            } else {

                //create new project with this name if doesn't already exist
                if (!Gbl.isProject(projectName1)) {
                    Project newProject = new Project(projectName1);
                    //////////////////////////////////////////////////////////////////////////
                    //   ProjectDBObj obj = new ProjectDBObj(newProject);
                    //   obj.save();
                    //////////////////////////////////////////////////////////////////////////
                    //add to all projects Database
                    Gbl.allProjectsDatabase.add(newProject);
                }
                //hide fab buttons on homescreen
                Gbl.hide_fab();
                //go to homescreen
                goHome();
            }
        //else editing project name
        }else{
            //pressing enter on existing project with no changes simply sends user home
            if (projectName1.equals("")) {
                goHome();
            //else user entered something so should change that projects name
            } else {
                Gbl.getProjWithName(Gbl.passProjName).setProjName(Gbl.getProjWithName(Gbl.passProjName),(projectName1));
                int pos = Gbl.getPos(Gbl.passProjName);
                //must also change proj name in list_of_projects
                Gbl.list_of_projects.set(pos, projectName1);

                goHome();
            }
        }



    }

    public String getProjName(){
        return Gbl.passProjName;
    }

    public void goHome(){
        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);
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
            size = 0;
        }
        String[] taskList = new String[size];
        if (!Gbl.passProjName.equals("New Project")){
            taskList = Gbl.allProjectsDatabase.get(i).getTaskList();
        }

        final ListView listView = (ListView) findViewById(R.id.project_task_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, taskList);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);
                Gbl.passTaskName = itemValue;
                goTask(listView);
            }
        });



    }


}
