package com.sumerge.tasksspringboot.Services;

import com.sumerge.tasksspringboot.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MoviesServices
{

    @Autowired
    @Qualifier("staticBobList")
    public StaticMovieService staticBobMovieService;

    @Autowired
    @Qualifier("staticAliceList")
    public StaticMovieService staticAliceMovieService;

    ArrayList<Movie> movies = new ArrayList<Movie>(Arrays.asList(
            new Movie("MOV1", 1.5,5),
            new Movie("MOV2", 1.9,8)
    ));

    public ArrayList<Movie> getMovies()
    {
        return movies;
    }
    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }
    public void updateMovie(Movie movie)
    {
        for(Movie mov: this.movies)
        {
            if(mov.getName().equals(movie.getName()))
                movies.remove(mov);
        }
        movies.add(movie);
    }
    public void deleteMovie(Movie movie)
    {
        for(Movie mov: this.movies)
        {
            if(mov.getName().equals(movie.getName()))
                movies.remove(mov);
        }
    }
}
