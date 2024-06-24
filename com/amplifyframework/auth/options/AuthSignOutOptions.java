package com.amplifyframework.auth.options;

import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public class AuthSignOutOptions {
    private final boolean globalSignOut;

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        private boolean globalSignOut = false;

        public AuthSignOutOptions build() {
            return new AuthSignOutOptions(this.globalSignOut);
        }

        public abstract T getThis();

        public T globalSignOut(boolean z) {
            this.globalSignOut = z;
            return getThis();
        }

        public boolean isGlobalSignOut() {
            return this.globalSignOut;
        }
    }

    /* loaded from: classes.dex */
    public static final class CoreBuilder extends Builder<CoreBuilder> {
        @Override // com.amplifyframework.auth.options.AuthSignOutOptions.Builder
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthSignOutOptions(boolean z) {
        this.globalSignOut = z;
    }

    public static Builder<?> builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isGlobalSignOut()), Boolean.valueOf(((AuthSignOutOptions) obj).isGlobalSignOut()));
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isGlobalSignOut()));
    }

    public boolean isGlobalSignOut() {
        return this.globalSignOut;
    }

    public String toString() {
        return "AuthSignOutOptions{globalSignOut=" + isGlobalSignOut() + '}';
    }
}
