package com.vladkuskov.SceneIt.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//This class will correspond to my movies table in top_movies DB
//Tells spring boot this is a JPA entity, mapped to a DB table
@Entity
//specify table name
@Table(name = "movies")
public class Movie {
    @Id
    private int id;

    private String title;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "vote_average")
    private BigDecimal voteAverage;

    @Column(name = "vote_count")
    private int voteCount;

    private BigDecimal popularity;

    @Column(columnDefinition = "TEXT")
    private String overview;

    @Column(name = "genre_ids", columnDefinition = "TEXT")
    private String genreIds;

    @Column(name = "genres", columnDefinition = "TEXT")
    private String genres;




    
    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(BigDecimal voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(String genreIds) {
        this.genreIds = genreIds;
    }

    public String getGenres() {
        return genres;
    }
    
    public void setGenres(String genres) {
        this.genres = genres;
    }
}
