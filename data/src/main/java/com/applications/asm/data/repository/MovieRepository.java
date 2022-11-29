package com.applications.asm.data.repository;

import com.applications.asm.domain.entities.MovieDetails;
import com.applications.asm.domain.entities.MovieSummary;
import com.applications.asm.domain.entities.Response;
import com.applications.asm.domain.repository.MoviesRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class MovieRepository implements MoviesRepository {
    @Override
    public Single<Response<List<MovieSummary>>> getPopularMovies(String language, Integer page) {
        return null;
    }

    @Override
    public Single<Response<List<MovieSummary>>> getTopRateMovies(String language, Integer page) {
        return null;
    }

    @Override
    public Single<Response<List<MovieSummary>>> getFavoritesMovies(String language) {
        return null;
    }

    @Override
    public Single<Response<MovieDetails>> getMovieDetails(String language, Integer movieId) {
        return null;
    }

    @Override
    public Single<Response<String>> addFavoritesMovies(MovieSummary movieSummary) {
        return null;
    }

    @Override
    public Single<Response<Boolean>> removeFromFavorites(String movieId) {
        return null;
    }
}
