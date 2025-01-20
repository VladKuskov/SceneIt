package com.vladkuskov.SceneIt.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vladkuskov.SceneIt.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //find movies by genre

    // error found: since in my DB the genres column is of type
    // text[], an array of strings, this method assumes that it is
    // just a string text column and not an array.
    // OLD: 
    // List<Movie> findByGenresContaining(String genre);
    // new:
    // Native query tells postgresql to check WHERE genres column
    // contains a specific genre
    @Query(value = "SELECT * FROM movies WHERE genres @> ARRAY[:genre]::text[]", nativeQuery = true)

List<Movie> findByGenre(@Param("genre") String genre);

    //find movies with a vote average greater than the given value
    List<Movie> findByVoteAverageGreaterThan(double voteAverage);

    //Filter movies by release year
@Query(value = "SELECT * FROM movies WHERE EXTRACT(YEAR FROM release_date) = :year", nativeQuery = true)
List<Movie> findByReleaseYear(@Param("year") int year);

    //Filter movies by vote average (greater than or equal)
List<Movie> findByVoteAverageGreaterThanEqual(double voteAverage);

@Query(value = "SELECT * FROM movies WHERE genres @> ARRAY[:genre]::text[]", nativeQuery = true)
List<Movie> findByGenresContaining(@Param("genre") String genre);
}