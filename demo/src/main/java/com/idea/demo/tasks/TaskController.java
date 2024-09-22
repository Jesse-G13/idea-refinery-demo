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

    private final TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/home")
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

    @GetMapping("/id{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Task getTaskId(@RequestParam(value="id") Integer id){

        return taskRepository.getTaskById(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCompleted(@RequestParam Boolean completed, @RequestParam Integer id){
        taskRepository.updateCompleted(completed,id);
    }

    @PutMapping("/updateDetails")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDetails(@RequestParam String title, @RequestParam String description, @RequestParam Integer id){
        taskRepository.updateDetails(title,description, id);
    }
}
