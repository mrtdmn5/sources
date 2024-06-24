package com.amplifyframework.api.rest;

import com.amplifyframework.api.ApiException;
import com.amplifyframework.core.Consumer;

/* loaded from: classes.dex */
public interface RestBehavior {
    RestOperation delete(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation delete(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation get(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation get(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation head(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation head(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation patch(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation patch(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation post(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation post(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation put(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);

    RestOperation put(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2);
}
