package com.example.bhouts.taskplanner;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffwag on 7/26/2016.
 */
public class ProjectDBObj extends SugarRecord {

    String projectName;

    public ProjectDBObj(){}
    public ProjectDBObj(Project project){
        this.projectName = project.ProjName;
    }

    public static ArrayList<Project> convertToProjects(){
        List<ProjectDBObj> projects = ProjectDBObj.listAll(ProjectDBObj.class);
        ArrayList<Project> converted = new ArrayList<Project>();
        for(ProjectDBObj obj: projects){
            converted.add(new Project(obj.projectName));
        }
        return converted;
    }
}
