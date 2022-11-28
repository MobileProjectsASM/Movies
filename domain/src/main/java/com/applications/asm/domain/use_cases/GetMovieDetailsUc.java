package com.applications.asm.domain.use_cases;

import com.applications.asm.domain.entities.MovieDetails;
import com.applications.asm.domain.entities.Response;
import com.applications.asm.domain.repository.MoviesRepository;
import com.applications.asm.domain.use_cases.base.SingleUseCase;
import com.applications.asm.domain.use_cases.base.UseCaseScheduler;

import io.reactivex.rxjava3.core.Single;

public class GetMovieDetailsUc extends SingleUseCase<Response<MovieDetails>, GetMovieDetailsUc.Params> {
    private final MoviesRepository moviesRepository;

    public static class Params {
        private final String language;
        private final Integer movieId;

        private Params(String language, Integer movieId) {
            this.language = language;
            this.movieId = movieId;
        }

        public static Params forGetCategories(String language, Integer movieId) {
            return new Params(language, movieId);
        }
    }

    public GetMovieDetailsUc(UseCaseScheduler useCaseScheduler, MoviesRepository moviesRepository) {
        super(useCaseScheduler);
        this.moviesRepository = moviesRepository;
    }

    @Override
    protected Single<Response<MovieDetails>> build(Params params) {
        return moviesRepository.getMovieDetails(params.language, params.movieId);
    }
}
