package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthSignInOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthSignInOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthSignInOptions extends AuthSignInOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthSignInOptions;
        }

        public int hashCode() {
            return DefaultAuthSignInOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthSignInOptions.class.getSimpleName();
        }

        private DefaultAuthSignInOptions() {
        }
    }

    public static DefaultAuthSignInOptions defaults() {
        return new DefaultAuthSignInOptions();
    }
}
