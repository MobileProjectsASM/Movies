package com.applications.asm.domain.use_cases;

import com.applications.asm.domain.entities.Response;
import com.applications.asm.domain.repository.MoviesRepository;
import com.applications.asm.domain.use_cases.base.SingleUseCase;
import com.applications.asm.domain.use_cases.base.UseCaseScheduler;

import io.reactivex.rxjava3.core.Single;

public class DeleteMovieToFavoritesUc extends SingleUseCase<Response<Boolean>, String> {
    private final MoviesRepository moviesRepository;

    public DeleteMovieToFavoritesUc(UseCaseScheduler useCaseScheduler, MoviesRepository moviesRepository) {
        super(useCaseScheduler);
        this.moviesRepository = moviesRepository;
    }


    @Override
    protected Single<Response<Boolean>> build(String movieId) {
        return moviesRepository.removeFromFavorites(movieId);
    }
}
