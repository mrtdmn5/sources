package com.amplifyframework.api.graphql;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/* loaded from: classes.dex */
public final class PaginatedResult<T> implements Iterable<T> {
    private final Iterable<T> items;
    private final GraphQLRequest<PaginatedResult<T>> requestForNextResult;

    public PaginatedResult(Iterable<T> iterable, GraphQLRequest<PaginatedResult<T>> graphQLRequest) {
        this.requestForNextResult = graphQLRequest;
        this.items = (Iterable) StreamSupport.stream(iterable.spliterator(), false).filter(new PaginatedResult$$ExternalSyntheticLambda0()).collect(Collectors.toList());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaginatedResult.class != obj.getClass()) {
            return false;
        }
        PaginatedResult paginatedResult = (PaginatedResult) obj;
        if (ObjectsCompat$Api19Impl.equals(this.requestForNextResult, paginatedResult.requestForNextResult) && ObjectsCompat$Api19Impl.equals(this.items, paginatedResult.items)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super T> consumer) {
        this.items.forEach(consumer);
    }

    public Iterable<T> getItems() {
        return this.items;
    }

    public GraphQLRequest<PaginatedResult<T>> getRequestForNextResult() {
        return this.requestForNextResult;
    }

    public boolean hasNextResult() {
        if (this.requestForNextResult != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.requestForNextResult, this.items);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.items.iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<T> spliterator() {
        return this.items.spliterator();
    }

    public String toString() {
        return "PaginatedResult{requestForNextResult=" + this.requestForNextResult + ", items=" + this.items + '}';
    }
}
