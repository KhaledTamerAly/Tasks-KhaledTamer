package com.sumerge.tasksspringboot.Controllers;

import com.sumerge.tasksspringboot.Services.MoviesServices;
import com.sumerge.tasksspringboot.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    @Autowired
    private MoviesServices moviesServices;

    @GetMapping(value = "/get-movies")
    public ArrayList<Movie> getMovies()
    {
        return moviesServices.getMovies();
    }
    @GetMapping(value = "/get-bob")
    public ArrayList<Movie> getBob()
    {
        return moviesServices.staticBobMovieService.MovieList();
    }

    @PostMapping(value = "/add-movie")
    public void addMovie(@RequestBody Movie movie)
    {
        moviesServices.addMovie(movie);
    }

    @PutMapping(value = "/update-movie")
    public void updateMovie(@RequestBody Movie movie)
    {
        moviesServices.updateMovie(movie);
    }

    @DeleteMapping(value = "/delete-movie")
    public void deleteMovie(@RequestBody Movie movie)
    {
        moviesServices.deleteMovie(movie);
    }
}
