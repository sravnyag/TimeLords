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
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class editProject extends AppCompatActivity {

    //variables for collapsible task list
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;



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

    //called when a task is selected
    public void goToTask(View view) {
        Intent go_ditTask = new Intent(this, editTask.class);
        startActivity(go_ditTask);
    }

    /*called when task fab button pushed- open ditTask, with preDetermined Project*/
    public void newTask_withDetProj(View view) {
        Intent go_ditTask = new Intent(this, editTask.class);
        startActivity(go_ditTask);
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
        //expandable project list
        ExpandList = (ExpandableListView) findViewById(R.id.ExpToDoList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(editProject.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);


    }

    //collapsible list of projects
    public ArrayList<ExpandListGroup> SetStandardGroups() {

        ArrayList<ExpandListGroup> grList = new ArrayList<ExpandListGroup>();

        ArrayList<ExpandListChild> chList = new ArrayList<ExpandListChild>();

        ExpandListGroup toDo = new ExpandListGroup();
        toDo.setName("To Do:");

        ExpandListGroup comp = new ExpandListGroup();
        comp.setName("Completed:");

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
        if (!Gbl.passProjName.equals("New Project")) {
            taskList = Gbl.allProjectsDatabase.get(i).getTaskList();
        }else{
            taskList[0] = "Just Do It!!";
        }
        //set To Do items
        for (int n=0;n<size;n++){
            final ExpandListChild ch = new ExpandListChild();
            String name = taskList[i];
            ch.setName(name);
            chList.add(ch);

            //listview on child click listener
            ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    //Gbl.passTaskName = Gbl.list_of_projects.get(childPosition);  //get tasks name
                    goToTask(ExpandList);
                    return false;
                }

            });

        }
        //set Completed items

        toDo.setItems(chList);
        comp.setItems(chList);
        grList.add(toDo);
        grList.add(comp);

        return grList;
    }


}
