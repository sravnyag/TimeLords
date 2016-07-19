package com.example.bhouts.taskplanner;

import android.support.design.widget.FloatingActionButton;

/**
 * Created by bhouts on 7/10/2016.
 */
public class Gbl {
    public static ProjectList All = new ProjectList();
    public static Task StartList = new Task(); //first task will simply show "TO DO:"
    public static Boolean hidden = Boolean.TRUE;
    public static FloatingActionButton fab_task;
    public static FloatingActionButton fab_project;
    public static FloatingActionButton fab_show;

}
