package com.amplifyframework.auth;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class AuthUserAttribute {
    private AuthUserAttributeKey key;
    private String value;

    public AuthUserAttribute(AuthUserAttributeKey authUserAttributeKey, String str) {
        this.key = authUserAttributeKey;
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUserAttribute.class != obj.getClass()) {
            return false;
        }
        AuthUserAttribute authUserAttribute = (AuthUserAttribute) obj;
        if (ObjectsCompat$Api19Impl.equals(getKey(), authUserAttribute.getKey()) && ObjectsCompat$Api19Impl.equals(getValue(), authUserAttribute.getValue())) {
            return true;
        }
        return false;
    }

    public AuthUserAttributeKey getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getKey(), getValue());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthUserAttribute {key=");
        sb.append(this.key);
        sb.append(", value=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.value, '}');
    }
}
