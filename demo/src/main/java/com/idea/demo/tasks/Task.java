package com.idea.demo.tasks;




import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class Task {
    private String title;
    private String description;
    private Boolean completed;
    private Date date;
    private Date completed_date;
    private int id;

    public Task() {
    }

    public Task(String title, String description, Boolean completed, Date date, Date completed_date, int id) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.date = date;
        this.completed_date = completed_date;


        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", date=" + date +
                ", completed_date=" + completed_date +
                ", id=" + id +
                '}';
    }
}
