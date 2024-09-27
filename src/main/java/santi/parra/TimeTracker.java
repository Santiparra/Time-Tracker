package santi.parra;

import santi.parra.data.Category;
import santi.parra.data.CurrentTasks;
import santi.parra.data.Task;
import santi.parra.utils.Args;
import santi.parra.utils.ArgsUtil;

public class TimeTracker {
    public static void main(String[] args) {

        ArgsUtil argsUtil = new ArgsUtil();
        Args arguments = argsUtil.parseArgs(args);

        CurrentTasks currentTasks = new CurrentTasks();


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


    }
}