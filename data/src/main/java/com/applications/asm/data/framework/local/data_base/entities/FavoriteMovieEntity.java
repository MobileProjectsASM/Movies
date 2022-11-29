package com.applications.asm.data.framework.local.data_base.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "FAVORITE_MOVIE", primaryKeys = "MovieId")
public class FavoriteMovieEntity {
    @NonNull
    @ColumnInfo(name = "MovieId")
    private String movieId;

    @NonNull
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(@NonNull String movieId) {
        this.movieId = movieId;
    }
}
