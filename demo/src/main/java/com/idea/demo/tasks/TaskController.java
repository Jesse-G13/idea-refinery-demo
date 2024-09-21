package com.idea.demo.tasks;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to the web-app";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody Task task){

        taskRepository.addTask(task);
    }

    @GetMapping("")
    public List<Task> getAllTasks(){

        return taskRepository.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskId(int id){

        return taskRepository.getTaskById(id);
    }

}
