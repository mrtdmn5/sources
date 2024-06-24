package com.amplifyframework.core.model.query;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.core.model.query.predicate.QueryPredicates;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class QueryOptions {
    private QueryPaginationInput paginationInput;
    private QueryPredicate queryPredicate;
    private List<QuerySortBy> sortBy;

    public QueryOptions(QueryPredicate queryPredicate, QueryPaginationInput queryPaginationInput, List<QuerySortBy> list) {
        this.queryPredicate = queryPredicate == null ? QueryPredicates.all() : queryPredicate;
        this.paginationInput = queryPaginationInput;
        this.sortBy = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryOptions)) {
            return false;
        }
        QueryOptions queryOptions = (QueryOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(this.queryPredicate, queryOptions.queryPredicate) && ObjectsCompat$Api19Impl.equals(this.paginationInput, queryOptions.paginationInput) && ObjectsCompat$Api19Impl.equals(this.sortBy, queryOptions.sortBy)) {
            return true;
        }
        return false;
    }

    public QueryPaginationInput getPaginationInput() {
        return this.paginationInput;
    }

    public QueryPredicate getQueryPredicate() {
        return this.queryPredicate;
    }

    public List<QuerySortBy> getSortBy() {
        return this.sortBy;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.queryPredicate, this.paginationInput, this.sortBy);
    }

    public QueryOptions matches(QueryPredicate queryPredicate) {
        Objects.requireNonNull(queryPredicate);
        return new QueryOptions(queryPredicate, this.paginationInput, this.sortBy);
    }

    public QueryOptions paginated(QueryPaginationInput queryPaginationInput) {
        QueryPredicate queryPredicate = this.queryPredicate;
        Objects.requireNonNull(queryPaginationInput);
        return new QueryOptions(queryPredicate, queryPaginationInput, this.sortBy);
    }

    public QueryOptions sorted(QuerySortBy... querySortByArr) {
        QueryPredicate queryPredicate = this.queryPredicate;
        QueryPaginationInput queryPaginationInput = this.paginationInput;
        Objects.requireNonNull(querySortByArr);
        return new QueryOptions(queryPredicate, queryPaginationInput, Arrays.asList(querySortByArr));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("QueryOptions{queryPredicate=");
        sb.append(this.queryPredicate);
        sb.append(", paginationInput=");
        sb.append(this.paginationInput);
        sb.append(", sortBy=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.sortBy, '}');
    }

    public QueryOptions() {
        this(null, null, null);
    }
}
