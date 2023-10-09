package com.sumerge.tasksspringboot.Services;

import com.sumerge.tasksspringboot.models.Movie;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class StaticMovieService
{

    private List<String> movieNames;
    private String name;

    public StaticMovieService(String name, List<String> movieNames)
    {
        this.name = name;
        this.movieNames = movieNames;
    }

    public ArrayList<Movie> MovieList() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for(String movieName: this.movieNames)
            movies.add(new Movie(movieName, 0,10));
        return movies;
    }
}
