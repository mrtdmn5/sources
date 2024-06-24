package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthUpdateUserAttributeOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthUpdateUserAttributeOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthUpdateUserAttributeOptions extends AuthUpdateUserAttributeOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthUpdateUserAttributeOptions;
        }

        public int hashCode() {
            return DefaultAuthUpdateUserAttributeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthUpdateUserAttributeOptions.class.getSimpleName();
        }

        private DefaultAuthUpdateUserAttributeOptions() {
        }
    }

    public static DefaultAuthUpdateUserAttributeOptions defaults() {
        return new DefaultAuthUpdateUserAttributeOptions();
    }
}
