package santi.parra;

import java.util.HashMap;
import java.util.Map;

public class CurrentTasks {

    private Map<String, Task> currentTasks = new HashMap<>();

    public Map<String, Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(Map<String, Task> currentTasks) {
        this.currentTasks = currentTasks;
    }
}
