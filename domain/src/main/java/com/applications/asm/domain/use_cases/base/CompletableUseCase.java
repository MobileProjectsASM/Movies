package com.applications.asm.domain.use_cases.base;

import com.applications.asm.domain.exceptions.ErrorUtils;

import java.util.logging.Logger;

import io.reactivex.rxjava3.core.Completable;

public abstract class CompletableUseCase<Params> extends UseCase<Completable, Params> {
    private UseCaseScheduler useCaseScheduler;
    private static final Logger logger = Logger.getLogger("com.applications.asm.domain.use_cases.base.CompletableUseCase");

    public CompletableUseCase(UseCaseScheduler useCaseScheduler) {
        this.useCaseScheduler = useCaseScheduler;
    }

    @Override
    protected Completable execute(Params params, Boolean fromUseCase) {
        return super.execute(params, fromUseCase)
                .compose(transform -> {
                    if(fromUseCase) return transform;
                    return transform.subscribeOn(useCaseScheduler.getRun()).observeOn(useCaseScheduler.getPost());
                })
                .onErrorResumeNext(throwable -> Completable.error(ErrorUtils.resolveError(logger, throwable, getClass())));
    }

    public UseCaseScheduler getUseCaseScheduler() {
        return useCaseScheduler;
    }

    public void setUseCaseScheduler(UseCaseScheduler useCaseScheduler) {
        this.useCaseScheduler = useCaseScheduler;
    }
}
