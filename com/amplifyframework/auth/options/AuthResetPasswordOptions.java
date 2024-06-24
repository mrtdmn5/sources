package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthResetPasswordOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthResetPasswordOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthResetPasswordOptions extends AuthResetPasswordOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResetPasswordOptions;
        }

        public int hashCode() {
            return DefaultAuthResetPasswordOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResetPasswordOptions.class.getSimpleName();
        }

        private DefaultAuthResetPasswordOptions() {
        }
    }

    public static DefaultAuthResetPasswordOptions defaults() {
        return new DefaultAuthResetPasswordOptions();
    }
}
