package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;
import java.lang.Comparable;

/* loaded from: classes.dex */
public final class BetweenQueryOperator<T extends Comparable<T>> extends QueryOperator<T> {
    private final T end;
    private final T start;

    public BetweenQueryOperator(T t, T t2) {
        super(QueryOperator.Type.BETWEEN);
        this.start = t;
        this.end = t2;
    }

    public T end() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BetweenQueryOperator.class != obj.getClass()) {
            return false;
        }
        BetweenQueryOperator betweenQueryOperator = (BetweenQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), betweenQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(start(), betweenQueryOperator.start()) && ObjectsCompat$Api19Impl.equals(end(), betweenQueryOperator.end())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), start(), end());
    }

    public T start() {
        return this.start;
    }

    public String toString() {
        return "BetweenQueryOperator { type: " + type() + ", start: " + this.start + ", end: " + this.end + " }";
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(T t) {
        return t.compareTo(this.start) >= 0 && t.compareTo(this.end) <= 0;
    }
}
