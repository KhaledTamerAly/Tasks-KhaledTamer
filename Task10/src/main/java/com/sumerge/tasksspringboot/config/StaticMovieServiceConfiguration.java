package com.sumerge.tasksspringboot.config;
import com.sumerge.tasksspringboot.Services.StaticMovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StaticMovieServiceConfiguration
{
    @Value("#{'${movieNames}'.split(',')}")
    List<String> movieNames;

    @Bean(name = "staticBobList")
    public StaticMovieService getMoviesServiceBob()
    {
        return new StaticMovieService("Bob", movieNames);
    }
    @Bean(name = "staticAliceList")
    public StaticMovieService getMoviesServiceAlice()
    {
        return new StaticMovieService("Alice", movieNames);
    }
}
