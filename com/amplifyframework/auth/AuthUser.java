package com.amplifyframework.auth;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthUser {
    private String userId;
    private String username;

    public AuthUser(String str, String str2) {
        Objects.requireNonNull(str);
        this.userId = str;
        Objects.requireNonNull(str2);
        this.username = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthUser.class != obj.getClass()) {
            return false;
        }
        AuthUser authUser = (AuthUser) obj;
        if (ObjectsCompat$Api19Impl.equals(getUserId(), authUser.getUserId()) && ObjectsCompat$Api19Impl.equals(getUsername(), authUser.getUsername())) {
            return true;
        }
        return false;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getUserId(), getUsername());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AuthUser{userId='");
        sb.append(this.userId);
        sb.append("', username='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.username, "'}");
    }
}
