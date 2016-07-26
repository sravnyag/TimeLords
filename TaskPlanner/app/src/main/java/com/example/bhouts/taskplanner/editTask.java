package com.example.bhouts.taskplanner;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.ArrayAdapter;

import java.util.Date;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.example.bhouts.taskplanner.Task;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class editTask extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

//    View.OnClickListener listen_task = null;
//    Button task_enter;



    public String collectNameInput() {
        final EditText taskName = (EditText) findViewById(R.id.taskName);
        String taskName1 = taskName.getText().toString();
        return taskName1;
    }

    public String collectProjectInput() {
        final EditText projectName = (EditText) findViewById(R.id.projectAttName);
        String projectName1 = projectName.getText().toString();
        return projectName1;
    }

    public String collectNotesInput() {
        final EditText notes = (EditText) findViewById(R.id.notes);
        String notes1 = notes.getText().toString();
        return notes1;
    }

/*    public String collectPriorityInput() {
        String priorityStr =
                ((EditText) findViewById(R.id.notes))
                        .getText().toString();
        return priorityStr;
    }

    public String collectTagInput() {
        String tagStr = ( (EditText) findViewById(R.id.)).getText().toString();
    }*/

    public Date collectDueDateInput() {
        try {
            DateFormat format =
                    new SimpleDateFormat("MM/dd/yyyy");
            String DueDateStr =
                    ((EditText) findViewById(R.id.textDueDate))
                            .getText().toString();
            Date newDate = format.parse(DueDateStr);
            return newDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void newTask() {
        Task newTask = new Task();
        newTask.setName(collectNameInput());
        newTask.setProject(collectProjectInput());
        newTask.setNotes(collectNotesInput());
        newTask.setDueDate(collectDueDateInput());
        //task.setPriority(collectPriorityInput());
        //task.editTags(collectTagInput());


        //set priorit level
        String priorityStr =
                ((EditText) findViewById(R.id.notes))
                        .getText().toString();
        newTask.setPriority(((priorityStr.equals(null)) ?
                "none" :
        priorityStr));
        }




    //when ENTER button clicked, go to homescreen
    public void goHSfromTask(View view) {
        newTask();
        Intent goHome = new Intent(this, HomeScreen.class);
        startActivity(goHome);

    }

    public void setHints(){//if simply ceating new task, reqular hints
        if (Gbl.passTaskName.equals("New Task")){
            ((TextView) findViewById(R.id.taskName)).setHint("Task:");
            ((TextView) findViewById(R.id.projectAttName)).setHint("Project:");
            ((TextView) findViewById(R.id.notes)).setHint("Notes:");
            ((TextView) findViewById(R.id.textDueDate)).setHint("Due Date:");
            //else the hint fields will display the task's attributes
        }else{
            ((TextView) findViewById(R.id.taskName)).setHint("Task: " + Gbl.passTaskName);
            ((TextView) findViewById(R.id.projectAttName)).setHint("Project: " + Gbl.passProjName);
            String notes = Gbl.getProjWithName(Gbl.passProjName).getTaskWithName(Gbl.passTaskName).getNotes();
            String date = Gbl.getProjWithName(Gbl.passProjName).getTaskWithName(Gbl.passTaskName).getDueDate().toString();
            ((TextView) findViewById(R.id.notes)).setHint("Notes: " + notes);
            ((TextView) findViewById(R.id.textDueDate)).setHint("Due Date:" + date);
        }
    }

    private Spinner priority;
    private Spinner tag;

    // dynamically set spinner elements
    public void populatePrioritySpinner(Spinner spinner1,
                                        Spinner spinner2) {
        List<String> priority_list = new ArrayList<String>();
        priority_list.add("High");
        priority_list.add("Med");
        priority_list.add("Low");
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
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
        tag_list.add("tag 1");
        tag_list.add("tag 2");
        tag_list.add("tag 3");
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
        setContentView(R.layout.activity_edit_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        setHints();
        populatePrioritySpinner(
                (Spinner) findViewById(R.id.priority_choice),
                (Spinner) findViewById(R.id.tag_choice)
        );

    }


}