package com.applications.asm.domain.entities;

import java.util.List;

public class MovieDetails {
    private final String movieTitle;
    private final Integer votes;
    private final String date;
    private final String description;
    private final List<String> languages;
    private final List<ProductionCompany> productionCompanies;
    private final Double rating;
    private final Boolean isFavorite;

    public MovieDetails(String movieTitle, Integer votes, String date, String description, List<String> languages, List<ProductionCompany> productionCompanies, Double rating, Boolean isFavorite) {
        this.movieTitle = movieTitle;
        this.votes = votes;
        this.date = date;
        this.description = description;
        this.languages = languages;
        this.productionCompanies = productionCompanies;
        this.rating = rating;
        this.isFavorite = isFavorite;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Integer getVotes() {
        return votes;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public Double getRating() {
        return rating;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }
}