package com.example.bhouts.taskplanner;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class editProject extends  AppCompatActivity {


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

    }

}
