package com.applications.asm.data.framework.network.api_rest;

import android.content.Context;
import android.util.Log;

import com.applications.asm.data.R;
import com.applications.asm.data.framework.network.api_rest.api.MovieDbApiClient;
import com.applications.asm.data.framework.network.api_rest.exceptions.RestException;
import com.applications.asm.data.framework.network.api_rest.exceptions.RestExceptionCodes;
import com.applications.asm.data.framework.network.api_rest.generator.ServiceGenerator;
import com.applications.asm.data.framework.network.api_rest.pojos.FilterMoviesResponse;
import com.applications.asm.data.framework.network.api_rest.pojos.MovieDetailsResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Objects;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class MovieRestServerImpl implements MoviesRestServer {
    private final ServiceGenerator<MovieDbApiClient> serviceGenerator;
    private final Context context;
    private final String apiKey;

    @Inject
    public MovieRestServerImpl(ServiceGenerator<MovieDbApiClient> serviceGenerator, Context context, String apiKey) {
        this.serviceGenerator = serviceGenerator;
        this.context = context;
        this.apiKey = apiKey;
    }

    @Override
    public Single<Response<FilterMoviesResponse>> getPopularMovies(String language, Integer page) {
        return serviceGenerator.getService(MovieDbApiClient.class)
                .getPopularMovies(apiKey, language, page)
                .onErrorResumeNext(throwable -> {
                    Exception exception = (Exception) throwable;
                    Log.e(getClass().getName(), exception.getMessage());
                    if(exception instanceof IOException)
                        return Single.error(new RestException(RestExceptionCodes.NETWORK_CONNECTION, context.getString(R.string.network_error)));
                    return Single.error(new RestException(RestExceptionCodes.PARSE_DATA_ERROR, context.getString(R.string.converter_error)));
                });
    }

    @Override
    public Single<Response<FilterMoviesResponse>> getTopRatedMovies(String language, Integer page) {
        return serviceGenerator.getService(MovieDbApiClient.class)
                .getTopRatedMovies(apiKey, language, page)
                .onErrorResumeNext(throwable -> {
                    Exception exception = (Exception) throwable;
                    Log.e(getClass().getName(), exception.getMessage());
                    if(exception instanceof IOException)
                        return Single.error(new RestException(RestExceptionCodes.NETWORK_CONNECTION, context.getString(R.string.network_error)));
                    return Single.error(new RestException(RestExceptionCodes.PARSE_DATA_ERROR, context.getString(R.string.converter_error)));
                });
    }

    @Override
    public Single<Response<MovieDetailsResponse>> getMovieDetails(Integer movieId, String language) {
        return serviceGenerator.getService(MovieDbApiClient.class)
                .getMovieDetails(movieId, apiKey, language)
                .onErrorResumeNext(throwable -> {
                    Exception exception = (Exception) throwable;
                    Log.e(getClass().getName(), exception.getMessage());
                    if(exception instanceof IOException)
                        return Single.error(new RestException(RestExceptionCodes.NETWORK_CONNECTION, context.getString(R.string.network_error)));
                    return Single.error(new RestException(RestExceptionCodes.PARSE_DATA_ERROR, context.getString(R.string.converter_error)));
                });
    }

    @Override
    public Error parseError(Response<?> response) {
        Converter<ResponseBody, Error> converter = serviceGenerator.getRetrofit().responseBodyConverter(Error.class, new Annotation[0]);
        try {
            return converter.convert(Objects.requireNonNull(response.errorBody()));
        } catch(IOException e) {
            return new Error();
        }
    }
}
