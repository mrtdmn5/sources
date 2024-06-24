package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthResendSignUpCodeOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthResendSignUpCodeOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthResendSignUpCodeOptions extends AuthResendSignUpCodeOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResendSignUpCodeOptions;
        }

        public int hashCode() {
            return DefaultAuthResendSignUpCodeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResendSignUpCodeOptions.class.getSimpleName();
        }

        private DefaultAuthResendSignUpCodeOptions() {
        }
    }

    public static DefaultAuthResendSignUpCodeOptions defaults() {
        return new DefaultAuthResendSignUpCodeOptions();
    }
}
