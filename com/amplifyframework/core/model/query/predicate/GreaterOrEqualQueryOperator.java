package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;
import java.lang.Comparable;

/* loaded from: classes.dex */
public final class GreaterOrEqualQueryOperator<T extends Comparable<T>> extends QueryOperator<T> {
    private final T value;

    public GreaterOrEqualQueryOperator(T t) {
        super(QueryOperator.Type.GREATER_OR_EQUAL);
        this.value = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GreaterOrEqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        GreaterOrEqualQueryOperator greaterOrEqualQueryOperator = (GreaterOrEqualQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), greaterOrEqualQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), greaterOrEqualQueryOperator.value())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "GreaterOrEqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public T value() {
        return this.value;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(T t) {
        return t.compareTo(this.value) >= 0;
    }
}
