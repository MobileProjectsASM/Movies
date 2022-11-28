package com.applications.asm.domain.use_cases;

import com.applications.asm.domain.entities.MovieSummary;
import com.applications.asm.domain.entities.Response;
import com.applications.asm.domain.repository.MoviesRepository;
import com.applications.asm.domain.use_cases.base.SingleUseCase;
import com.applications.asm.domain.use_cases.base.UseCaseScheduler;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class GetFavoritesMoviesUc extends SingleUseCase<Response<List<MovieSummary>>, GetFavoritesMoviesUc.Params> {
    private final MoviesRepository moviesRepository;

    public static class Params {
        private final String language;
        private final Integer page;

        private Params(String language, Integer page) {
            this.language = language;
            this.page = page;
        }

        public static Params forGetCategories(String language, Integer page) {
            return new Params(language, page);
        }
    }

    public GetFavoritesMoviesUc(UseCaseScheduler useCaseScheduler, MoviesRepository moviesRepository) {
        super(useCaseScheduler);
        this.moviesRepository = moviesRepository;
    }

    @Override
    protected Single<Response<List<MovieSummary>>> build(Params params) {
        return moviesRepository.getFavoritesMovies(params.language);
    }
}
