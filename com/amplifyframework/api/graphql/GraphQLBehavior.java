package com.amplifyframework.api.graphql;

import com.amplifyframework.api.ApiException;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;

/* loaded from: classes.dex */
public interface GraphQLBehavior {
    <T> GraphQLOperation<T> mutate(GraphQLRequest<T> graphQLRequest, Consumer<GraphQLResponse<T>> consumer, Consumer<ApiException> consumer2);

    <R> GraphQLOperation<R> mutate(String str, GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2);

    <R> GraphQLOperation<R> query(GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2);

    <R> GraphQLOperation<R> query(String str, GraphQLRequest<R> graphQLRequest, Consumer<GraphQLResponse<R>> consumer, Consumer<ApiException> consumer2);

    <R> GraphQLOperation<R> subscribe(GraphQLRequest<R> graphQLRequest, Consumer<String> consumer, Consumer<GraphQLResponse<R>> consumer2, Consumer<ApiException> consumer3, Action action);

    <R> GraphQLOperation<R> subscribe(String str, GraphQLRequest<R> graphQLRequest, Consumer<String> consumer, Consumer<GraphQLResponse<R>> consumer2, Consumer<ApiException> consumer3, Action action);
}
