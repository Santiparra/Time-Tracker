package santi.parra;

import santi.parra.data.Category;
import santi.parra.data.CurrentTasks;
import santi.parra.data.Task;
import santi.parra.utils.Args;
import santi.parra.utils.ArgsUtil;
import santi.parra.utils.FileUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class TimeTracker {
    public static void main(String[] args) throws IOException {

        ArgsUtil argsUtil = new ArgsUtil();
        Args arguments = argsUtil.parseArgs(args);

        FileUtil fileUtil = new FileUtil();
        CurrentTasks currentTasks = fileUtil.getSavedTasks();

        switch (arguments.getCommand()) {
            case TASK_START -> {
                Task task = new Task(
                        arguments.getTaskName(),
                        new Category(arguments.getCategoryName())
                );

                currentTasks.startTask(task);
            }
            case TASK_STOP -> currentTasks.completeTask(arguments.getTaskName());
            case REPORT_TASK -> {
                Map<String, Duration> taskReport = currentTasks.getTaskReport();
                for (Map.Entry<String, Duration> entry : taskReport.entrySet()) {
                    System.out.println("Task: " + entry.getKey());
                    System.out.println("Duration in minutes" + entry.getValue().toMinutes());
                }
            }
            case REPORT_CATEGORIES -> {
                Map<String, Duration> categoryReport = currentTasks.getCategoryReport();
                for (Map.Entry<String, Duration> entry : categoryReport.entrySet()) {
                    System.out.println("Category: " + entry.getKey());
                    System.out.println("Duration in minutes" + entry.getValue().toMinutes());
                }
            }
            default -> System.out.println("Something went wrong");

        }
        fileUtil.saveTasksToFile(currentTasks);


    }
}