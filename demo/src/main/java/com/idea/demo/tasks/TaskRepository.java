package com.idea.demo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository{
    private List<Task> taskRepo = new ArrayList<>();

    public List<Task> getAllTasks(){
        return taskRepo;
    }

    public void addTask(Task task){
        taskRepo.add(task);
    }

    public Task getTaskById(int id){
        for(Task task :taskRepo){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }

    public void updateCompleted(Boolean status, int id){
        for(Task task:taskRepo){
            if(task.getId() == id){
                task.setCompleted(status);
            }
        }
    }

    public void updateDetails(String title, String description, int id){
        for(Task task:taskRepo){
            if(task.getId() == id){
                task.setTitle(title);
                task.setDescription(description);
            }
        }
    }

}
