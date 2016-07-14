package com.example.bhouts.taskplanner;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import 	android.graphics.Color;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {

    OnClickListener listener1 = null;
    Button button1;



    /*called when fab button pushed*/
    public void newTask(View view) {
        Intent intent = new Intent(this, ditTask.class);
        startActivity(intent);
    }

    public void newProject(View view) {
        Intent intent1 = new Intent(this, editProject.class);
        startActivity(intent1);
    }

    public void show_hide() {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Gbl.fab_task = (FloatingActionButton) findViewById(R.id.fab_task);
        Gbl.fab_project = (FloatingActionButton) findViewById(R.id.fab_project);
        Gbl.fab_show = (FloatingActionButton) findViewById(R.id.fab_show);
        Gbl.fab_task.hide();
        Gbl.fab_project.hide();
        listener1 = new OnClickListener(){
            @Override
            public void onClick(View v) {
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
}
