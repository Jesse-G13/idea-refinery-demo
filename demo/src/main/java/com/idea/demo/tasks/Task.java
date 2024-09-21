package com.idea.demo.tasks;




import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(Date completed_date) {
        this.completed_date = completed_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
