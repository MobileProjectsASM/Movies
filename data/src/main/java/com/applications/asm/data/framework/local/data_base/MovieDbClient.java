package com.applications.asm.data.framework.local.data_base;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface MovieDbClient {
    Single<List<String>> getFavoriteMovies();
}
