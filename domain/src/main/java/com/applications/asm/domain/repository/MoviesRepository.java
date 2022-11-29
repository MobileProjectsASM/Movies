package com.applications.asm.domain.repository;

import com.applications.asm.domain.entities.MovieDetails;
import com.applications.asm.domain.entities.MovieSummary;
import com.applications.asm.domain.entities.Movies;
import com.applications.asm.domain.entities.Response;

import io.reactivex.rxjava3.core.Single;

public interface MoviesRepository {
    Single<Response<Movies<MovieSummary>>> getPopularMovies(String language, Integer page);
    Single<Response<Movies<MovieSummary>>> getTopRateMovies(String language, Integer page);
    Single<Response<Movies<MovieSummary>>> getFavoritesMovies(String language);
    Single<Response<MovieDetails>> getMovieDetails(String language, Integer movieId);
    Single<Response<String>> addFavoritesMovies(MovieSummary movieSummary);
    Single<Response<Boolean>> removeFromFavorites(String movieId);
}
