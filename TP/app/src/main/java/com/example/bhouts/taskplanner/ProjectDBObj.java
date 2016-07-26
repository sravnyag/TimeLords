package com.example.bhouts.taskplanner;

import com.orm.SugarRecord;

/**
 * Created by Jeffwag on 7/26/2016.
 */
public class ProjectDBObj extends SugarRecord {

    String projectName;

    public ProjectDBObj(){}

    public ProjectDBObj(Project project){
        projectName = project.ProjName;
    }
}
