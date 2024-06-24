package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: classes.dex */
public final class NotContainsQueryOperator extends QueryOperator<String> {
    private final String value;

    public NotContainsQueryOperator(String str) {
        super(QueryOperator.Type.NOT_CONTAINS);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NotContainsQueryOperator.class != obj.getClass()) {
            return false;
        }
        NotContainsQueryOperator notContainsQueryOperator = (NotContainsQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), notContainsQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), notContainsQueryOperator.value())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "NotContainsQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(String str) {
        return !str.contains(this.value);
    }
}
