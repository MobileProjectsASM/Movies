package com.applications.asm.data.framework.local.data_base;

import android.util.Log;

import com.applications.asm.data.framework.local.data_base.entities.FavoriteMovieEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public class MovieDbClientImpl implements MovieDbClient {
    private final MovieDatabase movieDatabase;

    @Inject
    public MovieDbClientImpl(MovieDatabase movieDatabase) {
        this.movieDatabase = movieDatabase;
    }

    @Override
    public Single<List<String>> getFavoriteMovies() {
        return movieDatabase.getFavoriteMoviesDao().getFavoriteMovies()
                .onErrorResumeNext(throwable -> {
                    Exception exception = (Exception) throwable;
                    Log.e(getClass().getName(), exception.getMessage());
                    return Single.error(new DatabaseException(DatabaseExceptionCodes.DATABASE_ERROR, exception.getMessage()));
                });
    }

    @Override
    public Completable addFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity) {
        return movieDatabase.getFavoriteMoviesDao().insertFavoriteMovie(favoriteMovieEntity);
    }

    @Override
    public Completable deleteFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity) {
        return movieDatabase.getFavoriteMoviesDao().deleteFavoriteMovie(favoriteMovieEntity);
    }
}
