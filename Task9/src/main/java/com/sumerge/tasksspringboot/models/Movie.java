package com.sumerge.tasksspringboot.models;


public class Movie {
    private String name;
    private double length;
    private double rating;

    public Movie(String name, double length, double rating)
    {
        this.name = name;
        this.length = length;
        this.rating = rating;
    }
    public String getName()
    {
        return this.name;
    }
}
