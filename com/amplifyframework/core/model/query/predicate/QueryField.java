package com.amplifyframework.core.model.query.predicate;

import com.amplifyframework.core.model.query.QuerySortBy;
import com.amplifyframework.core.model.query.QuerySortOrder;

/* loaded from: classes.dex */
public final class QueryField {
    private final String fieldName;
    private final String modelName;

    private QueryField(String str, String str2) {
        this.modelName = str;
        this.fieldName = str2;
    }

    public static QueryField field(String str) {
        return field(null, str);
    }

    public QuerySortBy ascending() {
        return new QuerySortBy(this.modelName, this.fieldName, QuerySortOrder.ASCENDING);
    }

    public QueryPredicateOperation<String> beginsWith(String str) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new BeginsWithQueryOperator(str));
    }

    public <T extends Comparable<T>> QueryPredicateOperation<T> between(T t, T t2) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new BetweenQueryOperator(t, t2));
    }

    public QueryPredicateOperation<String> contains(String str) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new ContainsQueryOperator(str));
    }

    public QuerySortBy descending() {
        return new QuerySortBy(this.modelName, this.fieldName, QuerySortOrder.DESCENDING);
    }

    public QueryPredicateOperation<Object> eq(Object obj) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new EqualQueryOperator(obj));
    }

    public <T extends Comparable<T>> QueryPredicateOperation<T> ge(T t) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new GreaterOrEqualQueryOperator(t));
    }

    public <T extends Comparable<T>> QueryPredicateOperation<T> gt(T t) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new GreaterThanQueryOperator(t));
    }

    public <T extends Comparable<T>> QueryPredicateOperation<T> le(T t) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new LessOrEqualQueryOperator(t));
    }

    public <T extends Comparable<T>> QueryPredicateOperation<T> lt(T t) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new LessThanQueryOperator(t));
    }

    public QueryPredicateOperation<Object> ne(Object obj) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new NotEqualQueryOperator(obj));
    }

    public QueryPredicateOperation<String> notContains(String str) {
        return new QueryPredicateOperation<>(this.modelName, this.fieldName, new NotContainsQueryOperator(str));
    }

    public static QueryField field(String str, String str2) {
        return new QueryField(str, str2);
    }
}
