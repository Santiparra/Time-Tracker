package santi.parra;

import santi.parra.data.Category;
import santi.parra.data.CurrentTasks;
import santi.parra.data.Task;
import santi.parra.utils.Args;
import santi.parra.utils.ArgsUtil;
import santi.parra.utils.FileUtil;

import java.io.IOException;

public class TimeTracker {
    public static void main(String[] args) throws IOException {

        ArgsUtil argsUtil = new ArgsUtil();
        Args arguments = argsUtil.parseArgs(args);

        FileUtil fileUtil = new FileUtil();
        CurrentTasks currentTasks = fileUtil.getSavedTasks();

        switch (arguments.getCommand().name()) {
            case "TASK_START" -> {
                Task task = new Task(
                        arguments.getTaskName(),
                        new Category(arguments.getCategoryName())
                );

                currentTasks.startTask(task);
            }
            case "TASK_STOP" -> currentTasks.completeTask(arguments.getTaskName());

        }
        System.out.println(currentTasks);
        fileUtil.saveTasksToFile(currentTasks);


    }
}