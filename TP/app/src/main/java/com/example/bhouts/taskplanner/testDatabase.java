package com.example.bhouts.taskplanner;

/**
 * Created by Jeffwag on 7/19/2016.
 */
import com.example.bhouts.taskplanner.DatabaseClass;
import com.example.bhouts.taskplanner.Task;
import android.util.Log;
public class testDatabase {
    public testDatabase(DatabaseOperations db, Task task) {
        db.addTask(task);
        Log.d("Testdatabase class", "test ran successfully");

    }

}
