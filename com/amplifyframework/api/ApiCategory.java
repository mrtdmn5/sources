package com.amplifyframework.api;

import com.amplifyframework.api.graphql.GraphQLOperation;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.rest.RestOperation;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.api.rest.RestResponse;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.category.CategoryType;

/* loaded from: classes.dex */
public final class ApiCategory extends Category<ApiPlugin<?>> implements ApiCategoryBehavior {
    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation delete(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().delete(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation get(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().get(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.core.category.CategoryTypeable
    public CategoryType getCategoryType() {
        return CategoryType.API;
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation head(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().head(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <R> GraphQLOperation<R> mutate(GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2) {
        return (GraphQLOperation<R>) getSelectedPlugin().mutate(graphQLRequest, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation patch(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().patch(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation post(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().post(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation put(RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().put(restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <R> GraphQLOperation<R> query(GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().query(graphQLRequest, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <T> GraphQLOperation<T> subscribe(GraphQLRequest<T> graphQLRequest, Consumer<String> consumer, Consumer<GraphQLResponse<T>> consumer2, Consumer<ApiException> consumer3, Action action) {
        return (GraphQLOperation<T>) getSelectedPlugin().subscribe(graphQLRequest, consumer, consumer2, consumer3, action);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation delete(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().delete(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation get(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().get(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation head(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().head(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <T> GraphQLOperation<T> mutate(String str, GraphQLRequest<T> graphQLRequest, Consumer<GraphQLResponse<T>> consumer, Consumer<ApiException> consumer2) {
        return (GraphQLOperation<T>) getSelectedPlugin().mutate(str, graphQLRequest, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation patch(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().patch(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation post(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().post(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.rest.RestBehavior
    public RestOperation put(String str, RestOptions restOptions, Consumer<RestResponse> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().put(str, restOptions, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <R> GraphQLOperation<R> query(String str, GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2) {
        return getSelectedPlugin().query(str, graphQLRequest, consumer, consumer2);
    }

    @Override // com.amplifyframework.api.graphql.GraphQLBehavior
    public <T> GraphQLOperation<T> subscribe(String str, GraphQLRequest<T> graphQLRequest, Consumer<String> consumer, Consumer<GraphQLResponse<T>> consumer2, Consumer<ApiException> consumer3, Action action) {
        return (GraphQLOperation<T>) getSelectedPlugin().subscribe(str, graphQLRequest, consumer, consumer2, consumer3, action);
    }
}
