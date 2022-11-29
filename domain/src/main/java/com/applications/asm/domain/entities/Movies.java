package com.applications.asm.domain.entities;

import java.util.List;

public class Movies<T> {
    private final Integer currentPage;
    private final Integer totalPage;
    private final List<T> movies;

    public Movies(Integer currentPage, Integer totalPage, List<T> movies) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.movies = movies;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<T> getMovies() {
        return movies;
    }
}
