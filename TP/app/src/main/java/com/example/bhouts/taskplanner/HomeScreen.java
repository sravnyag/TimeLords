package com.example.bhouts.taskplanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import 	android.graphics.Color;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class HomeScreen extends AppCompatActivity {
    private boolean stop = true;
    OnClickListener listener1 = null;
    Button button1;


    /*called when fab button pushed*/
    public void newTask(View view) {
        Intent go_ditTask = new Intent(this, ditTask.class);
        startActivity(go_ditTask);
    }

    //called when fab button pushed/ when project from collapsible list is pushed
    public void newProject(View view) {
        Intent go_editProject = new Intent(this, editProject.class);
        startActivity(go_editProject);
    }

    //called when Dump button pushed..send to dump page
    public void goDump(View view) {
        Intent go_dump = new Intent(this, Dump.class);
        startActivity(go_dump);
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

        if(Gbl.list_of_projects.isEmpty()){
            //create dump
            Project dump = new Project("Dump");
            Gbl.dump = dump;
            Gbl.allProjectsDatabase.add(Gbl.dump);
        }

      /*  if (stop == true) {
           // Project createDump = new Project("Dump");
           // Gbl.dump = createDump;
           // Gbl.allProjectsDatabase.add(Gbl.dump);
           // Gbl.dump = createDump;
            ProjectDBObj db = new ProjectDBObj();
            List<ProjectDBObj> listDB = ProjectDBObj.listAll(ProjectDBObj.class);
            if (!listDB.isEmpty()) {
                for(int i=0; i<listDB.size(); i++) {
                    Project temp = listDB.get(i).getProject();
                    Gbl.allProjectsDatabase.add(temp);
                    Gbl.list_of_projects.add(listDB.get(i).getProjectName());
                }
            }
            stop = false;


        }   */


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
        listener1 = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Gbl.passProjName = "New Project";
                if (Gbl.hidden == Boolean.TRUE) {
                    Gbl.fab_task.show();
                    Gbl.fab_project.show();
                    Gbl.hidden = Boolean.FALSE;
                } else {
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
        // ProjectDBObj db = new ProjectDBObj();
        // List<ProjectDBObj> listDB = ProjectDBObj.listAll(ProjectDBObj.class);
        //if (!listDB.isEmpty()) {
        //    for(int i=0; i<listDB.size(); i++) {
        //        Project temp = listDB.get(i).getProject();
        //        Gbl.list_of_projects.add(temp.getProjName());
        //    }
        //}
        //int count = listDB.size();
        //String test = String.valueOf(count);
        //Toast.makeText(this,test,Toast.LENGTH_SHORT).show();
        //System.out.println("hello");
      /*  for (int i=0;i<listDB.size();i++){
            System.out.println("hello");
            final ExpandListChild ch = new ExpandListChild();
            String name = listDB.get(i).getProjectName();
            ch.setName(name);
            chList.add(ch);
*/
        for (int i = 0; i < Gbl.list_of_projects.size(); i++) {
            final ExpandListChild ch = new ExpandListChild();
            String name = Gbl.list_of_projects.get(i);
            ch.setName(name);
            chList.add(ch);

/*
            ExpandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    System.out.print("kill me");
                    ProjectDBObj db = new ProjectDBObj();
                    System.out.print("kill me 2");
                    List<ProjectDBObj> listDB = ProjectDBObj.listAll(ProjectDBObj.class);
                    System.out.print("kill me 3");
                    Gbl.passProjName = listDB.get(childPosition).getProjectName();
                    System.out.print("kill me 4");
                    newProject(ExpandList);
                    System.out.print("kill me as well");
                    return false;
                }

            });  */
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


