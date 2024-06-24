package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: classes.dex */
public final class EqualQueryOperator extends QueryOperator<Object> {
    private final Object value;

    public EqualQueryOperator(Object obj) {
        super(QueryOperator.Type.EQUAL);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EqualQueryOperator.class != obj.getClass()) {
            return false;
        }
        EqualQueryOperator equalQueryOperator = (EqualQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), equalQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), equalQueryOperator.value())) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(Object obj) {
        return obj.equals(this.value);
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "EqualQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }
}
