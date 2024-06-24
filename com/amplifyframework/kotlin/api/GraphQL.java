package com.amplifyframework.kotlin.api;

import com.amplifyframework.api.ApiException;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.GraphQLResponse;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GraphQL.kt */
/* loaded from: classes.dex */
public interface GraphQL {

    /* compiled from: GraphQL.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object mutate$default(GraphQL graphQL, GraphQLRequest graphQLRequest, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return graphQL.mutate(graphQLRequest, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mutate");
        }

        public static /* synthetic */ Object query$default(GraphQL graphQL, GraphQLRequest graphQLRequest, String str, Continuation continuation, int r4, Object obj) throws ApiException {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return graphQL.query(graphQLRequest, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }

        public static /* synthetic */ Object subscribe$default(GraphQL graphQL, GraphQLRequest graphQLRequest, String str, Continuation continuation, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    str = null;
                }
                return graphQL.subscribe(graphQLRequest, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
        }
    }

    <T> Object mutate(GraphQLRequest<T> graphQLRequest, String str, Continuation<? super GraphQLResponse<T>> continuation) throws ApiException;

    <T> Object query(GraphQLRequest<T> graphQLRequest, String str, Continuation<? super GraphQLResponse<T>> continuation) throws ApiException;

    <T> Object subscribe(GraphQLRequest<T> graphQLRequest, String str, Continuation<? super Flow<GraphQLResponse<T>>> continuation);
}
