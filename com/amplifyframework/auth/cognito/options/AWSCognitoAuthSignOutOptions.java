package com.amplifyframework.auth.cognito.options;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.options.AuthSignOutOptions;

/* loaded from: classes.dex */
public final class AWSCognitoAuthSignOutOptions extends AuthSignOutOptions {
    private final String browserPackage;

    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthSignOutOptions.Builder<CognitoBuilder> {
        private String browserPackage;

        public CognitoBuilder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthSignOutOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthSignOutOptions.Builder
        public AWSCognitoAuthSignOutOptions build() {
            return new AWSCognitoAuthSignOutOptions(super.isGlobalSignOut(), this.browserPackage);
        }
    }

    public AWSCognitoAuthSignOutOptions(boolean z, String str) {
        super(z);
        this.browserPackage = str;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    @Override // com.amplifyframework.auth.options.AuthSignOutOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSignOutOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthSignOutOptions aWSCognitoAuthSignOutOptions = (AWSCognitoAuthSignOutOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(Boolean.valueOf(isGlobalSignOut()), Boolean.valueOf(aWSCognitoAuthSignOutOptions.isGlobalSignOut())) && ObjectsCompat$Api19Impl.equals(getBrowserPackage(), aWSCognitoAuthSignOutOptions.getBrowserPackage())) {
            return true;
        }
        return false;
    }

    public String getBrowserPackage() {
        return this.browserPackage;
    }

    @Override // com.amplifyframework.auth.options.AuthSignOutOptions
    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(isGlobalSignOut()), getBrowserPackage());
    }

    @Override // com.amplifyframework.auth.options.AuthSignOutOptions
    public String toString() {
        return "AWSCognitoAuthSignOutOptions{isGlobalSignOut=" + isGlobalSignOut() + ", browserPackage=" + getBrowserPackage() + '}';
    }
}
