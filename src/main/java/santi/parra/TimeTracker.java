package santi.parra;

import santi.parra.data.Category;
import santi.parra.data.CurrentTasks;
import santi.parra.data.Task;

import java.util.Arrays;

public class TimeTracker {
    public static void main(String[] args) {

        if (args.length < 2) {
            Logger.log("Error: Not enough arguments");
        }
        String command = args[0];

        CurrentTasks currentTasks = new CurrentTasks();

        switch (command) {
            case "start":

                Task task = new Task(taskName, new Category(categoryName));
                currentTasks.startTask(task);
                break;
            case "stop":

        }

    }
}