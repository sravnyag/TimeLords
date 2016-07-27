package com.example.bhouts.taskplanner;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeffwag on 7/26/2016.
 */
public class ProjectDBObj extends SugarRecord {

    String projectName;
    Project proj;

    public ProjectDBObj(){}
    public ProjectDBObj(Project project){
        this.projectName = project.ProjName;
        this.proj = project;
    }

    public static ArrayList<Project> convertToProjects(){
        List<ProjectDBObj> projects = ProjectDBObj.listAll(ProjectDBObj.class);
        ArrayList<Project> converted = new ArrayList<Project>();
        for(ProjectDBObj obj: projects){
            converted.add(new Project(obj.projectName));
        }
        return converted;
    }
    public Project getProject() {
        return proj;
    }
    public String getProjectName() {
        return projectName;
    }
    /*public Project findProject(String name) {
        List<ProjectDBObj> projects = ProjectDBObj.listAll(ProjectDBObj.class);
        for(int i=0;i<projects.size();i++) {
            if(name.equals(projects.get(i).getProject().getProjName())) {
                return projects.get(i).getProject();
            }
        }
    }    */


}
