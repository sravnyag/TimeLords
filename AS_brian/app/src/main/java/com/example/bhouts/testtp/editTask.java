package com.example.bhouts.testtp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class editTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] tasksTest = {"Task:", "Project", "Notes:", "Do Date:", "Completed?:"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasksTest);

        ListView TheTaskList = (ListView) findViewById(R.id.TheTaskList);

        TheTaskList.setAdapter(theAdapter);

        TheTaskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String taskPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));

                        Toast.makeText(editTask.this, taskPicked, Toast.LENGTH_SHORT).show();
            }
        });
    }



}


