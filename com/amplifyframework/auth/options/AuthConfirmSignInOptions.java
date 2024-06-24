package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthConfirmSignInOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthConfirmSignInOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthConfirmSignInOptions extends AuthConfirmSignInOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmSignInOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmSignInOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmSignInOptions.class.getSimpleName();
        }

        private DefaultAuthConfirmSignInOptions() {
        }
    }

    public static DefaultAuthConfirmSignInOptions defaults() {
        return new DefaultAuthConfirmSignInOptions();
    }
}
