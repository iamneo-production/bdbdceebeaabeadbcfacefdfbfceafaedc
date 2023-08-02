package com.examly.springapp;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
 
@Repository
public interface TaskRepository  extends JpaRepository<Task,String>{
Optional<Task> findByTaskId(String taskid);
void deleteByTaskId(String taskid);

}