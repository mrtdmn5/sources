package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;
import java.lang.Comparable;

/* loaded from: classes.dex */
public final class GreaterThanQueryOperator<T extends Comparable<T>> extends QueryOperator<T> {
    private final T value;

    public GreaterThanQueryOperator(T t) {
        super(QueryOperator.Type.GREATER_THAN);
        this.value = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GreaterThanQueryOperator.class != obj.getClass()) {
            return false;
        }
        GreaterThanQueryOperator greaterThanQueryOperator = (GreaterThanQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), greaterThanQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), greaterThanQueryOperator.value())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "GreaterThanQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public T value() {
        return this.value;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(T t) {
        return t.compareTo(this.value) > 0;
    }
}
