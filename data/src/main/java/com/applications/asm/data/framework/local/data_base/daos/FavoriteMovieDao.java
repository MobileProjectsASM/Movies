package com.applications.asm.data.framework.local.data_base.daos;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface FavoriteMovieDao {
    @Query("SELECT * FROM FAVORITE_MOVIE")
    Single<List<String>> getFavoriteMovies();
}
