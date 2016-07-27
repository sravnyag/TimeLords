package com.example.bhouts.taskplanner;

import org.junit.Test;

/**
 * Created by Julia on 7/27/2016.
 */
public class ProjectUnitTest {

    //constructor
    //setID
    //getID

    @Test
    public void constructor_printValues() {
        System.out.println("Testing constructor:");
        Project project = new Project("project name");
        System.out.println("Project name should be 'project name'");
        System.out.println("Project name is: " + project.ProjName);
        System.out.println();
    }


}
