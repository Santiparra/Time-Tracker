package santi.parra;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CurrentTasks {

    private Map<String, Task> currentTasks = new HashMap<>();

    private void startTask(Task task) {
        if (currentTasks.putIfAbsent(task.getTaskName(), task) != null) {
            Logger.log("Task already exist, skipping!");
        }
    }

    private void completeTask(Task task) {
        Task existingTask = currentTasks.get(task.getTaskName());
        if (existingTask == null) {
            Logger.log("No task found");
        } else {
            existingTask.setEndTime(LocalDateTime.now());
            existingTask.setStatus(TaskStatus.COMPLETE);
        }
    }

    public Map<String, Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(Map<String, Task> currentTasks) {
        this.currentTasks = currentTasks;
    }
}
