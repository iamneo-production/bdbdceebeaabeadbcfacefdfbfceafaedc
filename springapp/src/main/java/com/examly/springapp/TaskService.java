
package com.examly.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    
    public Task changeTaskStatus(String taskId, String taskStatus) {
        Task task = taskRepository.findByTaskId(taskId);
        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }
    
    public void deleteTask(String taskId) {
        Task task = taskRepository.findByTaskId(taskId);
        taskRepository.delete(task);
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Task getTaskByTaskId(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }
}