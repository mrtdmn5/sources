package com.amplifyframework.core.model.query;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.util.Wrap;
import java.util.Objects;

/* loaded from: classes.dex */
public final class QuerySortBy {
    private final String field;
    private final String modelName;
    private final QuerySortOrder sortOrder;

    public QuerySortBy(String str, QuerySortOrder querySortOrder) {
        this(null, str, querySortOrder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QuerySortBy.class != obj.getClass()) {
            return false;
        }
        QuerySortBy querySortBy = (QuerySortBy) obj;
        if (ObjectsCompat$Api19Impl.equals(this.modelName, querySortBy.modelName) && ObjectsCompat$Api19Impl.equals(this.field, querySortBy.field) && ObjectsCompat$Api19Impl.equals(this.sortOrder, querySortBy.sortOrder)) {
            return true;
        }
        return false;
    }

    public String getField() {
        return this.field;
    }

    public String getModelName() {
        return this.modelName;
    }

    public QuerySortOrder getSortOrder() {
        return this.sortOrder;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.modelName, this.field, this.sortOrder);
    }

    public String toString() {
        String inSingleQuotes;
        StringBuilder sb = new StringBuilder("QuerySortBy{model=");
        String str = this.modelName;
        if (str == null) {
            inSingleQuotes = null;
        } else {
            inSingleQuotes = Wrap.inSingleQuotes(str);
        }
        sb.append(inSingleQuotes);
        sb.append(", field=");
        sb.append(Wrap.inSingleQuotes(this.field));
        sb.append(", sortOrder=");
        sb.append(this.sortOrder);
        sb.append('}');
        return sb.toString();
    }

    public QuerySortBy(String str, String str2, QuerySortOrder querySortOrder) {
        this.modelName = str;
        Objects.requireNonNull(str2);
        this.field = str2;
        Objects.requireNonNull(querySortOrder);
        this.sortOrder = querySortOrder;
    }
}
