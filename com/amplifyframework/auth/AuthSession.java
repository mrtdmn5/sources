package com.amplifyframework.auth;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public class AuthSession {
    private final boolean isSignedIn;

    public AuthSession(boolean z) {
        this.isSignedIn = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isSignedIn()), Boolean.valueOf(((AuthSession) obj).isSignedIn()));
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isSignedIn()));
    }

    public boolean isSignedIn() {
        return this.isSignedIn;
    }

    public String toString() {
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("AuthSession{isSignedIn="), this.isSignedIn, '}');
    }
}
