package com.amplifyframework.core.model.query.predicate;

import com.amplifyframework.core.model.query.predicate.QueryPredicateGroup;
import java.util.Collections;

/* loaded from: classes.dex */
public interface QueryPredicate extends Evaluable<Object> {
    static QueryPredicate not(QueryPredicate queryPredicate) {
        return new QueryPredicateGroup(QueryPredicateGroup.Type.NOT, Collections.singletonList(queryPredicate));
    }

    QueryPredicate and(QueryPredicate queryPredicate);

    QueryPredicate or(QueryPredicate queryPredicate);
}
