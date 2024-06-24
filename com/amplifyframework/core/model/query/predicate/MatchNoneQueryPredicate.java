package com.amplifyframework.core.model.query.predicate;

/* loaded from: classes.dex */
final class MatchNoneQueryPredicate implements QueryPredicate {
    private MatchNoneQueryPredicate() {
    }

    public static MatchNoneQueryPredicate instance() {
        return new MatchNoneQueryPredicate();
    }

    public boolean equals(Object obj) {
        return obj instanceof MatchNoneQueryPredicate;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(Object obj) {
        return false;
    }

    public int hashCode() {
        return MatchNoneQueryPredicate.class.hashCode();
    }

    public String toString() {
        return "MatchNoneQueryPredicate";
    }

    @Override // com.amplifyframework.core.model.query.predicate.QueryPredicate
    public QueryPredicate and(QueryPredicate queryPredicate) {
        return this;
    }

    @Override // com.amplifyframework.core.model.query.predicate.QueryPredicate
    public QueryPredicate or(QueryPredicate queryPredicate) {
        return queryPredicate;
    }
}
