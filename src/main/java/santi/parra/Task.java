package santi.parra;

import java.time.LocalDateTime;

public class Task {

    private String taskName;
    private Category category;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Task() {
    }

    public Task(String taskName, Category category, LocalDateTime startTime, LocalDateTime endTime) {
        this.taskName = taskName;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
