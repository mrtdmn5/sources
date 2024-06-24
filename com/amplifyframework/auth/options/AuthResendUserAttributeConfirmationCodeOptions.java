package com.amplifyframework.auth.options;

/* loaded from: classes.dex */
public abstract class AuthResendUserAttributeConfirmationCodeOptions {

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public abstract AuthResendUserAttributeConfirmationCodeOptions build();

        public abstract T getThis();
    }

    /* loaded from: classes.dex */
    public static final class DefaultAuthResendUserAttributeConfirmationCodeOptions extends AuthResendUserAttributeConfirmationCodeOptions {
        public boolean equals(Object obj) {
            return obj instanceof DefaultAuthResendUserAttributeConfirmationCodeOptions;
        }

        public int hashCode() {
            return DefaultAuthResendUserAttributeConfirmationCodeOptions.class.hashCode();
        }

        public String toString() {
            return DefaultAuthResendUserAttributeConfirmationCodeOptions.class.getSimpleName();
        }

        private DefaultAuthResendUserAttributeConfirmationCodeOptions() {
        }
    }

    public static DefaultAuthResendUserAttributeConfirmationCodeOptions defaults() {
        return new DefaultAuthResendUserAttributeConfirmationCodeOptions();
    }
}
