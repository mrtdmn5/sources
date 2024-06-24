package com.amplifyframework.auth;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public class AuthProvider {
    private static final String AMAZON = "amazon";
    private static final String APPLE = "apple";
    private static final String FACEBOOK = "facebook";
    private static final String GOOGLE = "google";
    private final String providerKey;

    public AuthProvider(String str) {
        this.providerKey = str;
    }

    public static AuthProvider amazon() {
        return new AuthProvider(AMAZON);
    }

    public static AuthProvider apple() {
        return new AuthProvider(APPLE);
    }

    public static AuthProvider custom(String str) {
        return new AuthProvider(str);
    }

    public static AuthProvider facebook() {
        return new AuthProvider(FACEBOOK);
    }

    public static AuthProvider google() {
        return new AuthProvider(GOOGLE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getProviderKey(), ((AuthProvider) obj).getProviderKey());
        }
        return false;
    }

    public String getProviderKey() {
        return this.providerKey;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getProviderKey());
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("AuthProvider{providerKey="), this.providerKey, '}');
    }
}
