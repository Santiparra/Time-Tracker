package santi.parra.data;

import santi.parra.Logger;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrentTasks {

    private Map<String, Task> currentTasks = new HashMap<>();

    public CurrentTasks(Map<String, Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public void startTask(Task task) {
        if (currentTasks.putIfAbsent(task.getTaskName(), task) != null) {
            Logger.log("Task already exist, skipping!");
        }
    }

    public void completeTask(String taskName) {
        Task existingTask = currentTasks.get(taskName);
        if (existingTask == null) {
            Logger.log("No task found");
        } else {
            existingTask.setEndTime(LocalDateTime.now());
            existingTask.setStatus(TaskStatus.COMPLETE);
        }
    }

    public Map<String, Duration> getTaskReport() {
        return currentTasks
                .values()
                .stream()
                .filter(task -> task.getEndTime() != null)
                .collect(Collectors.toMap(Task::getTaskName, Task::getTaskDuration));
    }

    public Map<String, Duration> getCategoryReport() {
        Map<String, Duration> categoryReport = new HashMap<>();
        currentTasks
                .values()
                .stream()
                .filter(task -> task.getEndTime() != null)
                .forEach(task -> {
                    String category = task.getCategory().getName();
                    Duration categoryDuration = categoryReport.getOrDefault(
                            category,
                            Duration.ZERO
                            );
                    categoryReport.put(task.getCategory().getName(), categoryDuration.plus(task.getTaskDuration()));
                });
        return categoryReport;
    }

    public Map<String, Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(Map<String, Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    @Override
    public String toString() {
        return "CurrentTasks{" +
                "currentTasks=" + currentTasks +
                '}';
    }
}
