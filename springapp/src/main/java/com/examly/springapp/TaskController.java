package com.examly.springapp;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    
     @GetMapping("/changeStatus")
     public Task changeTaskStatus(@RequestParam String id, @RequestParam String status) {
         return taskService.changeTaskStatus(id, status);
     }
    
    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam String id) {
        taskService.deleteTask(id);
    }
    
    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/getTask")
    public Task getTaskByTaskId(@RequestParam String id) {
        return taskService.getTaskByTaskId(id);
    }
}