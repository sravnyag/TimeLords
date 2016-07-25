package com.example.bhouts.taskplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;

import java.util.ArrayList;

import android.widget.ExpandableListView;
import android.widget.SlidingDrawer;


public class HomeScreen extends AppCompatActivity {

    OnClickListener listener1 = null;
    Button button1;



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

    //called when Dump button pushed..send to dump page
    public void goDump(View view) {
        Intent go_dump = new Intent(this, Dump.class);
        startActivity(go_dump);
    }

    //called when qTask button pushed..send to dump page
    public void goQtask(View view) {
        Intent go_qTask = new Intent(this, qTask.class);
        startActivity(go_qTask);
    }

    //called when Urgent button pushed..send to dump page
    public void goUrgent(View view) {
        Intent go_urgent = new Intent(this, Urgent.class);
        startActivity(go_urgent);
    }


    //variables for collapsible project list
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //expandable project list
        ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(HomeScreen.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        //declare fab buttons
        Gbl.fab_task = (FloatingActionButton) findViewById(R.id.fab_task);
        Gbl.fab_project = (FloatingActionButton) findViewById(R.id.fab_project);
        Gbl.fab_show = (FloatingActionButton) findViewById(R.id.fab_show);
        //initially hide these two fabs
        Gbl.fab_task.hide();
        Gbl.fab_project.hide();
        listener1 = new OnClickListener(){
            @Override
            public void onClick(View v) {
                Gbl.passProjName = "New Project";
                Gbl.passTaskName = "New Task";
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
        Gbl.fab_show.setOnClickListener(listener1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //collapsible list of projects
    public ArrayList<ExpandListGroup> SetStandardGroups() {

        ArrayList<ExpandListGroup> grList = new ArrayList<ExpandListGroup>();

        ArrayList<ExpandListChild> chList = new ArrayList<ExpandListChild>();

        ExpandListGroup grup = new ExpandListGroup();
        grup.setName("Projects");

        for (int i=0;i<Gbl.list_of_projects.size();i++){
            final ExpandListChild ch = new ExpandListChild();
            String name = Gbl.list_of_projects.get(i);
            ch.setName(name);
            chList.add(ch);

            //listview on child click listener
            ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    Gbl.passProjName = Gbl.list_of_projects.get(childPosition);
                    newProject(ExpandList);
                    return false;
                }

            });

        }

        grup.setItems(chList);

        grList.add(grup);

        return grList;
    }

}
