package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthConfirmSignUpOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthConfirmSignUpOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthConfirmSignUpOptions extends AuthConfirmSignUpOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthConfirmSignUpOptions;
        }

        public int hashCode() {
            return DefaultAuthConfirmSignUpOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthConfirmSignUpOptions.class.getSimpleName();
        }

        private DefaultAuthConfirmSignUpOptions() {
        }
    }

    public static DefaultAuthConfirmSignUpOptions defaults() {
        return new DefaultAuthConfirmSignUpOptions();
    }
}
