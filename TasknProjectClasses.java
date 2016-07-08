import java.util.*;
import java.util.ArrayList;

class Task{
	public String Tname;    //task name
	public String Pname;	 //associated poject
	public String Notes;    //task description
	public Boolean Completed;
	public Task(String TaskName, String ProjectName, String Des){
		Tname = TaskName;
		Pname = ProjectName;
		Notes = Des;
		Completed = false;
		
	}
}

class ProjectList{
	public String MyName;        //name
	public ArrayList<Task> TaskList = new ArrayList<Task>();   //list of tasks
	public ProjectList(){
		MyName = "All Projects";
		this.TaskList.add(Gbl.StartList);
	}
	public void newtask(Task DoThis){
		this.TaskList.add(DoThis);
	}
}

class Project extends ProjectList{
	public Project(String ThisName){
		Task MyName = new Task(ThisName,"",""); //cast String as Task so can add to te global projectlist "All"
		Gbl.All.TaskList.add(MyName);
	}
}

//class to declare neccessary "global" variables
class Gbl {
    public static ProjectList All = new ProjectList();
    public static Task StartList = new Task("TO DO:", "", ""); //first task will simply show "TO DO:"
}


//test class
class TasknProjectClasses {

	public static void main(String[] args) {
		System.out.println(Gbl.All.MyName);
	}

}