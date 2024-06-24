package com.amplifyframework.core.model.query.predicate;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.query.predicate.QueryOperator;

/* loaded from: classes.dex */
public final class BeginsWithQueryOperator extends QueryOperator<String> {
    private final String value;

    public BeginsWithQueryOperator(String str) {
        super(QueryOperator.Type.BEGINS_WITH);
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BeginsWithQueryOperator.class != obj.getClass()) {
            return false;
        }
        BeginsWithQueryOperator beginsWithQueryOperator = (BeginsWithQueryOperator) obj;
        if (ObjectsCompat$Api19Impl.equals(type(), beginsWithQueryOperator.type()) && ObjectsCompat$Api19Impl.equals(value(), beginsWithQueryOperator.value())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(type(), value());
    }

    public String toString() {
        return "BeginsWithQueryOperator { type: " + type() + ", value: " + value() + " }";
    }

    public Object value() {
        return this.value;
    }

    @Override // com.amplifyframework.core.model.query.predicate.Evaluable
    public boolean evaluate(String str) {
        return str.indexOf(this.value) == 0;
    }
}
