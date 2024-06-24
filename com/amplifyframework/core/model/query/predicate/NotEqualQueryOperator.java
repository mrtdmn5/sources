package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: classes.dex */
public final class NotEqualQueryOperator extends QueryOperator<Object> {
    private final Object value;

    public NotEqualQueryOperator(Object obj) {
        super(QueryOperator.Type.NOT_EQUAL);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NotEqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        NotEqualQueryOperator notEqualQueryOperator = (NotEqualQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), notEqualQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), notEqualQueryOperator.value())) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(Object obj) {
        return !obj.equals(this.value);
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "NotEqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }
}
