package com.applications.asm.data.framework.network.api_rest;

import com.applications.asm.data.framework.network.api_rest.pojos.FilterMoviesResponse;
import com.applications.asm.data.framework.network.api_rest.pojos.MovieDetailsResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;

public interface MoviesRestServer {
    Single<Response<FilterMoviesResponse>> getPopularMovies(String language, Integer page);
    Single<Response<FilterMoviesResponse>> getTopRatedMovies(String language, Integer page);
    Single<Response<MovieDetailsResponse>> getMovieDetails(Integer movieId, String language);
    Error parseError(Response<?> response);
}
