package com.learningmachine.android.app.data.webservice;

import com.learningmachine.android.app.data.webservice.request.IssuerIntroductionPayload;
import com.learningmachine.android.app.data.webservice.response.IssuerResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

public interface IssuerService {

    @GET
    Observable<IssuerResponse> getIssuer(@Url String url);

    @POST
    Observable<Void> doIntroduction(@Url String url, @Body IssuerIntroductionPayload payload);
}
