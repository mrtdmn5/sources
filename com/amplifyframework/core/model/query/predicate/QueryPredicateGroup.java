package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class QueryPredicateGroup implements QueryPredicate {
    private final List<QueryPredicate> predicates;
    private final Type type;

    /* renamed from: com.amplifyframework.core.model.query.predicate.QueryPredicateGroup$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type = r0;
            try {
                r0[Type.OR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[Type.AND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[Type.NOT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Type {
        AND,
        OR,
        NOT
    }

    public QueryPredicateGroup(Type type, List<QueryPredicate> list) {
        this.type = type;
        this.predicates = new ArrayList(list);
        if (!list.isEmpty()) {
        } else {
            throw new IllegalArgumentException("A predicate group must contain at least one predicate element");
        }
    }

    public static QueryPredicate andOf(QueryPredicate queryPredicate) {
        return new QueryPredicateGroup(Type.AND, Arrays.asList(queryPredicate));
    }

    public static QueryPredicateGroup not(QueryPredicateGroup queryPredicateGroup) {
        return new QueryPredicateGroup(Type.NOT, Collections.singletonList(queryPredicateGroup));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QueryPredicateGroup.class != obj.getClass()) {
            return false;
        }
        QueryPredicateGroup queryPredicateGroup = (QueryPredicateGroup) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), queryPredicateGroup.type()) && ObjectsCompat$Api19Impl.equals(predicates(), queryPredicateGroup.predicates())) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(Object obj) throws IllegalArgumentException {
        int r0 = AnonymousClass1.$SwitchMap$com$amplifyframework$core$model$query$predicate$QueryPredicateGroup$Type[this.type.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    return false;
                }
                return !this.predicates.get(0).evaluate(obj);
            }
            Iterator<QueryPredicate> it = this.predicates.iterator();
            while (it.hasNext()) {
                if (!it.next().evaluate(obj)) {
                    return false;
                }
            }
            return true;
        }
        Iterator<QueryPredicate> it2 = this.predicates.iterator();
        while (it2.hasNext()) {
            if (it2.next().evaluate(obj)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), predicates());
    }

    public List<QueryPredicate> predicates() {
        return this.predicates;
    }

    public String toString() {
        return "QueryPredicateGroup { type: " + type() + ", predicates: " + predicates() + " }";
    }

    public Type type() {
        return this.type;
    }

    @Override // com.amplifyframework.core.model.query.predicate.QueryPredicate
    public QueryPredicateGroup and(QueryPredicate queryPredicate) {
        Type type = Type.AND;
        if (type.equals(this.type)) {
            this.predicates.add(queryPredicate);
            return this;
        }
        return new QueryPredicateGroup(type, Arrays.asList(this, queryPredicate));
    }

    @Override // com.amplifyframework.core.model.query.predicate.QueryPredicate
    public QueryPredicateGroup or(QueryPredicate queryPredicate) {
        Type type = Type.OR;
        if (type.equals(this.type)) {
            this.predicates.add(queryPredicate);
            return this;
        }
        return new QueryPredicateGroup(type, Arrays.asList(this, queryPredicate));
    }
}
