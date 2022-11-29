package com.applications.asm.data.framework.local.data_base.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.applications.asm.data.framework.local.data_base.entities.FavoriteMovieEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface FavoriteMovieDao {
    @Query("SELECT * FROM FAVORITE_MOVIE")
    Single<List<String>> getFavoriteMovies();

    @Insert
    Completable insertFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity);

    @Delete
    Completable deleteFavoriteMovie(FavoriteMovieEntity favoriteMovieEntity);
}
