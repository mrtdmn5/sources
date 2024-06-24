package com.amplifyframework.api.graphql;

import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class GraphQLPathSegment {
    private final Object value;

    public GraphQLPathSegment(int r1) {
        this.value = Integer.valueOf(r1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GraphQLPathSegment.class == obj.getClass()) {
            GraphQLPathSegment graphQLPathSegment = (GraphQLPathSegment) obj;
            if (isString() && graphQLPathSegment.isString()) {
                return ObjectsCompat$Api19Impl.equals(getAsString(), graphQLPathSegment.getAsString());
            }
            if (isInteger() && graphQLPathSegment.isInteger()) {
                return ObjectsCompat$Api19Impl.equals(Integer.valueOf(getAsInt()), Integer.valueOf(graphQLPathSegment.getAsInt()));
            }
        }
        return false;
    }

    public int getAsInt() {
        if (isInteger()) {
            return ((Integer) this.value).intValue();
        }
        throw new ClassCastException("Not an int: ".concat(this.value.getClass().getSimpleName()));
    }

    public String getAsString() {
        if (isString()) {
            return (String) this.value;
        }
        throw new ClassCastException("Not a String: ".concat(this.value.getClass().getSimpleName()));
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean isInteger() {
        return this.value instanceof Integer;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public String toString() {
        return "GraphQLPathSegment{value='" + this.value + "'}";
    }

    public GraphQLPathSegment(String str) {
        this.value = str;
    }
}
