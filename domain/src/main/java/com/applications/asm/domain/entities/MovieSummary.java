package com.applications.asm.domain.entities;

public class MovieSummary {
    private final String movieTitle;
    private final String movieImage;
    private final String movieDate;
    private final String movieSummary;
    private final Integer rating;
    private final Boolean isFavorite;

    public MovieSummary(String movieTitle, String movieImage, String movieDate, String movieSummary, Integer rating, Boolean isFavorite) {
        this.movieTitle = movieTitle;
        this.movieImage = movieImage;
        this.movieDate = movieDate;
        this.movieSummary = movieSummary;
        this.rating = rating;
        this.isFavorite = isFavorite;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public Integer getRating() {
        return rating;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }
}
