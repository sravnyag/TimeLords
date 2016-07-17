package com.example.bhouts.taskplanner;

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

public class ditTask extends AppCompatActivity {

    View.OnClickListener listen_task = null;
    Button task_enter;

    private Spinner priority;
    private Spinner tag;

    // dynamically set spinner elements
    public void populatePrioritySpinner(Spinner spinner1,
                                        Spinner spinner2) {
        List<String> priority_list = new ArrayList<String>();
        priority_list.add("priority 1");
        priority_list.add("priority 2");
        priority_list.add("priority 3");
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
        ArrayAdapter<String> dataAdapter2 =
                new ArrayAdapter<String>(this, android.R.layout
                        .simple_spinner_item, tag_list);
        dataAdapter2.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        task_enter = (Button) findViewById(R.id.task_enter);

        //when task_done button pushed, creates new Task instance
        listen_task = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final EditText taskName =
                        (EditText) findViewById(R.id.taskName);
                String taskName1 = taskName.getText().toString();

                final EditText projectName =
                        (EditText) findViewById(R.id.projectAttName);
                String projectName1 =
                        projectName.getText().toString();

                final EditText notes =
                        (EditText) findViewById(R.id.notes);
                String notes1 = notes.getText().toString();

                Task newTask = new Task();
            }
        };
        task_enter.setOnClickListener(listen_task);

        Spinner priority = (Spinner) findViewById(R.id.priority_choice);
        Spinner tag = (Spinner) findViewById(R.id.tag_choice);
        populatePrioritySpinner(priority, tag); // run test list
    }
}