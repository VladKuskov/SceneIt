package com.vladkuskov.SceneIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladkuskov.SceneIt.entity.Movie;
import com.vladkuskov.SceneIt.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    //get all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    //get movies by genre
    // OLD:
    //@GetMapping("/movies/genre/{genre}")
    //public List<Movie> getMoviesByGenre(@PathVariable String genre) {
    //    System.out.println("Searching for genre: " + genre); // Debug log
    //    List<Movie> movies = movieRepository.findByGenresContaining(genre);
    //    System.out.println("Movies found: " + movies.size()); // Debug log
    //    return movies;
    //}
    // NEW: changes name to match new repository method
    @GetMapping("/genre/{genre}")
public List<Movie> getMoviesByGenre(@PathVariable String genre) {
    System.out.println("Searching for genre: " + genre); // Debug log, "genre" depends on directory entry
    List<Movie> movies = movieRepository.findByGenre(genre);
    System.out.println("Movies found: " + movies.size()); // Debug log
    return movies;
}

    //get top rated movies
    @GetMapping("/top-rated")
    public List<Movie> getTopRatedMovies() {
        //Will later add ability to filter by ratings
        return movieRepository.findByVoteAverageGreaterThan(8.5);
    }

    //Get movies by release year
@GetMapping("/year/{year}")
public List<Movie> getMoviesByYear(@PathVariable int year) {
    return movieRepository.findByReleaseYear(year);
}

    //Get movies with a vote average greater than or equal to specified value
@GetMapping("/rating/{rating}")
public List<Movie> getMoviesByRating(@PathVariable double rating) {
    return movieRepository.findByVoteAverageGreaterThanEqual(rating);
}
}