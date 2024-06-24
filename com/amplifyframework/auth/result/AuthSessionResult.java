package com.amplifyframework.auth.result;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthException;

/* loaded from: classes.dex */
public final class AuthSessionResult<T> {
    private final AuthException error;
    private final Type type;
    private final T value;

    /* loaded from: classes.dex */
    public enum Type {
        SUCCESS,
        FAILURE
    }

    private AuthSessionResult(T t, AuthException authException, Type type) {
        this.value = t;
        this.error = authException;
        this.type = type;
    }

    public static <T> AuthSessionResult<T> failure(AuthException authException) {
        return new AuthSessionResult<>(null, authException, Type.FAILURE);
    }

    public static <T> AuthSessionResult<T> success(T t) {
        return new AuthSessionResult<>(t, null, Type.SUCCESS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthSessionResult)) {
            return false;
        }
        AuthSessionResult authSessionResult = (AuthSessionResult) obj;
        if (ObjectsCompat$Api19Impl.equals(getValue(), authSessionResult.getValue()) && ObjectsCompat$Api19Impl.equals(getError(), authSessionResult.getError()) && ObjectsCompat$Api19Impl.equals(getType(), authSessionResult.getType())) {
            return true;
        }
        return false;
    }

    public AuthException getError() {
        return this.error;
    }

    public Type getType() {
        return this.type;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getValue(), getError(), getType());
    }

    public String toString() {
        return "AuthSessionResult{value=" + getValue() + ", error=" + getError() + ", type=" + getType() + '}';
    }
}
