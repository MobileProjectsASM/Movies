package com.applications.asm.data.framework.local.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.applications.asm.data.framework.local.data_base.daos.FavoriteMovieDao;
import com.applications.asm.data.framework.local.data_base.entities.FavoriteMovieEntity;

@Database(entities = { FavoriteMovieEntity.class }, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract FavoriteMovieDao getFavoriteMoviesDao();
}
