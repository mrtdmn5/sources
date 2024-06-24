package com.amplifyframework.core.model.query;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class QueryPaginationInput {
    public static final int DEFAULT_LIMIT = 100;
    private final int limit;
    private final int page;

    public QueryPaginationInput(int r1, int r2) {
        this.page = r1;
        this.limit = r2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPaginationInput)) {
            return false;
        }
        QueryPaginationInput queryPaginationInput = (QueryPaginationInput) obj;
        if (this.page == queryPaginationInput.page && this.limit == queryPaginationInput.limit) {
            return true;
        }
        return false;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getPage() {
        return this.page;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Integer.valueOf(this.page), Integer.valueOf(this.limit));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("QueryPaginationInput{page=");
        sb.append(this.page);
        sb.append(", limit=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.limit, '}');
    }

    public QueryPaginationInput withLimit(Integer num) {
        return new QueryPaginationInput(this.page, num.intValue());
    }
}
