package com.applications.asm.domain.use_cases;

import com.applications.asm.domain.entities.MovieSummary;
import com.applications.asm.domain.entities.Response;
import com.applications.asm.domain.repository.MoviesRepository;
import com.applications.asm.domain.use_cases.base.SingleUseCase;
import com.applications.asm.domain.use_cases.base.UseCaseScheduler;

import io.reactivex.rxjava3.core.Single;

public class AddMovieToFavoritesUc extends SingleUseCase<Response<String>, MovieSummary> {
    private final MoviesRepository moviesRepository;

    public AddMovieToFavoritesUc(UseCaseScheduler useCaseScheduler, MoviesRepository moviesRepository) {
        super(useCaseScheduler);
        this.moviesRepository = moviesRepository;
    }

    @Override
    protected Single<Response<String>> build(MovieSummary movieSummary) {
        return moviesRepository.addFavoritesMovies(movieSummary);
    }
}
