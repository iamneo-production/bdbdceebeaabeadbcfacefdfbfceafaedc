package com.examly.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task saveTask(Task taskentity){
        repository.save(taskentity);
        return taskentity;
    }

    public Task updatetaskStatus(String taskId){
        Optional<Task> taskentity = repository.findByTaskId(taskId);
        if(taskentity.isPresent()){
            taskentity.get().setTaskStatus("Accepted");
            repository.save(taskentity.get());
            return taskentity.get();
        }
        return null;
        
    }


    public String deleteTask(String id){
        Optional<Task> taskentity = repository.findByTaskId(id);
        if(taskentity.isPresent()){
            repository.deleteByTaskId(id);
            return"Task Deleted Successfully";
        }
        return "User not Found";
    }


    public List<Task> getallTasks(){
        return repository.findAll();
    }

    public Task gettaskbyid(String id){
        Optional<Task> taskentity = repository.findByTaskId(id);
        if(taskentity.isPresent()){
            return taskentity.get();
        }
        return null;
    }

    

}