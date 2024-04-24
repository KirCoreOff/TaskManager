package com.example.TaskManager.service;

import com.example.TaskManager.models.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private long taskId = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM HH:mm");
    private final List<Task> taskList = new ArrayList<>();
    {
        taskList.add(new Task(++taskId, LocalDateTime.now().format(formatter), LocalDateTime.now().format(formatter), "Install Idea", "Install and configure Idea for working", "New", new ArrayList<>()));
        taskList.add(new Task(++taskId, LocalDateTime.now().format(formatter), LocalDateTime.now().format(formatter), "Learn Spring", "Create simple MVC app", "New", new ArrayList<>()));
    }

    public List<Task> getTasks() { return taskList; }

    public boolean addTask(Task task) {
        task.setId(++taskId);
        task.setCreateTime(LocalDateTime.now().format(formatter));
        task.setLastUpdateTime(LocalDateTime.now().format(formatter));
        task.setStatus("New");
        task.setComments(new ArrayList<>());
        taskList.add(task);
        return true;
    }

    public boolean deleteTask(long id) {
        for (Task task:taskList) {
            taskList.remove(task);
            return true;
        }
        return false;
    }

    public Task getTaskById(long id) {
        for (Task task : taskList)
            if (task.getId() == id) return task;
        return null;
    }

    public boolean updateTask(long id, Task newTask) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setTitle(newTask.getTitle());
                task.setDescription(newTask.getDescription());
                task.setStatus(newTask.getStatus());
                task.setLastUpdateTime(LocalDateTime.now().format(formatter));
                return true;
            }
        }
        return false;
    }
}
