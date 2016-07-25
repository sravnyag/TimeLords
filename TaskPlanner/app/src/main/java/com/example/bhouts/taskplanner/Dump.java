package com.example.bhouts.taskplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Dump extends AppCompatActivity {

    View.OnClickListener listener2 = null;
    Button button2;

    /*called when fab button pushed*/
    public void newTask(View view) {
        Intent go_ditTask = new Intent(this, editTask.class);
        startActivity(go_ditTask);
    }

    //called when fab button pushed/ when project from collapsible list is pushed
    public void newProject(View view){
        Intent go_editProject = new Intent(this, editProject.class);
        startActivity(go_editProject);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dump);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //declare fab buttons
        Gbl.fab_task = (FloatingActionButton) findViewById(R.id.fab_task);
        Gbl.fab_project = (FloatingActionButton) findViewById(R.id.fab_project);
        Gbl.fab_show = (FloatingActionButton) findViewById(R.id.fab_show);
        //initially hide these two fabs
        Gbl.fab_task.hide();
        Gbl.fab_project.hide();

        listener2 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Gbl.passProjName = "New Project";
                if (Gbl.hidden == Boolean.TRUE){
                    Gbl.fab_task.show();
                    Gbl.fab_project.show();
                    Gbl.hidden = Boolean.FALSE;
                }else {
                    Gbl.fab_task.hide();
                    Gbl.fab_project.hide();
                    Gbl.hidden = Boolean.TRUE;
                }

            }
        };
        Gbl.fab_show.setOnClickListener(listener2);


    }
}