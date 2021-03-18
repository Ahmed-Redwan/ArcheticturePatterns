package com.ahmed.archeticturepatterns.pogo;

public class MovieModel {

private String name;
private String data;
private String Description;
private int id;

    public MovieModel(String name, String data, String description, int id) {
        this.name = name;
        this.data = data;
        Description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
