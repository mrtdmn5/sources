package com.amplifyframework.core.model.query;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.core.model.query.predicate.QueryPredicates;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ObserveQueryOptions {
    private final QueryPredicate queryPredicate;
    private final List<QuerySortBy> sortBy;

    public ObserveQueryOptions(QueryPredicate queryPredicate, List<QuerySortBy> list) {
        this.queryPredicate = queryPredicate == null ? QueryPredicates.all() : queryPredicate;
        this.sortBy = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObserveQueryOptions)) {
            return false;
        }
        ObserveQueryOptions observeQueryOptions = (ObserveQueryOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(this.queryPredicate, observeQueryOptions.queryPredicate) && ObjectsCompat$Api19Impl.equals(this.sortBy, observeQueryOptions.sortBy)) {
            return true;
        }
        return false;
    }

    public QueryPredicate getQueryPredicate() {
        return this.queryPredicate;
    }

    public List<QuerySortBy> getSortBy() {
        return this.sortBy;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.queryPredicate, this.sortBy);
    }

    public ObserveQueryOptions matches(QueryPredicate queryPredicate) {
        Objects.requireNonNull(queryPredicate);
        return new ObserveQueryOptions(queryPredicate, this.sortBy);
    }

    public ObserveQueryOptions sorted(QuerySortBy... querySortByArr) {
        QueryPredicate queryPredicate = this.queryPredicate;
        Objects.requireNonNull(querySortByArr);
        return new ObserveQueryOptions(queryPredicate, Arrays.asList(querySortByArr));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("QueryOptions{queryPredicate=");
        sb.append(this.queryPredicate);
        sb.append(", sortBy=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.sortBy, '}');
    }

    public ObserveQueryOptions() {
        this(null, null);
    }
}
