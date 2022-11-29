package com.applications.asm.data.framework.network.api_rest.api;

import com.applications.asm.data.framework.network.api_rest.pojos.FilterMoviesResponse;
import com.applications.asm.data.framework.network.api_rest.pojos.MovieDetailsResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDbApiClient {
    @GET("3/movie/popular")
    Single<Response<FilterMoviesResponse>> getPopularMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") Integer page);

    @GET("3/movie/top_rated")
    Single<Response<FilterMoviesResponse>> getTopRatedMovies(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") Integer page);

    @GET("3/movie/{movie_id}")
    Single<Response<MovieDetailsResponse>> getMovieDetails(@Path("movie_id") Integer movieId, @Query("api_key") String apiKey, @Query("language") String language);
}
