package com.applications.asm.data.framework.local.data_base;

import com.applications.asm.data.framework.local.data_base.entities.FavoriteMovieEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

public interface MovieDbClient {
    Single<List<String>> getFavoriteMovies();
    Completable addFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity);
    Completable deleteFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity);
}
