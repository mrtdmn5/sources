package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthConfirmResetPasswordOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthConfirmResetPasswordOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthConfirmResetPasswordOptions extends AuthConfirmResetPasswordOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmResetPasswordOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmResetPasswordOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmResetPasswordOptions.class.getSimpleName();
        }

        private DefaultAuthConfirmResetPasswordOptions() {
        }
    }

    public static DefaultAuthConfirmResetPasswordOptions defaults() {
        return new DefaultAuthConfirmResetPasswordOptions();
    }
}
