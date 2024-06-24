package com.amplifyframework.auth.cognito.options;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.options.AuthWebUISignInOptions;
import com.amplifyframework.util.Immutable;
import java.util.List;

/* loaded from: classes.dex */
public final class AWSCognitoAuthWebUISignInOptions extends AuthWebUISignInOptions {
    private final String browserPackage;
    private final String idpIdentifier;

    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthWebUISignInOptions.Builder<CognitoBuilder> {
        private String browserPackage;
        private String idpIdentifier;

        public CognitoBuilder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public CognitoBuilder idpIdentifier(String str) {
            this.idpIdentifier = str;
            return getThis();
        }

        @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions.Builder
        public AWSCognitoAuthWebUISignInOptions build() {
            return new AWSCognitoAuthWebUISignInOptions(Immutable.of(super.getScopes()), this.idpIdentifier, this.browserPackage);
        }
    }

    public AWSCognitoAuthWebUISignInOptions(List<String> list, String str, String str2) {
        super(list);
        this.idpIdentifier = str;
        this.browserPackage = str2;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthWebUISignInOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthWebUISignInOptions aWSCognitoAuthWebUISignInOptions = (AWSCognitoAuthWebUISignInOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getScopes(), aWSCognitoAuthWebUISignInOptions.getScopes()) && ObjectsCompat$Api19Impl.equals(getIdpIdentifier(), aWSCognitoAuthWebUISignInOptions.getIdpIdentifier()) && ObjectsCompat$Api19Impl.equals(getBrowserPackage(), aWSCognitoAuthWebUISignInOptions.getBrowserPackage())) {
            return true;
        }
        return false;
    }

    public String getBrowserPackage() {
        return this.browserPackage;
    }

    public String getIdpIdentifier() {
        return this.idpIdentifier;
    }

    @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions
    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getScopes(), getIdpIdentifier(), getBrowserPackage());
    }

    @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions
    public String toString() {
        return "AWSCognitoAuthWebUISignInOptions{scopes=" + getScopes() + ", idpIdentifier=" + getIdpIdentifier() + ", browserPackage=" + getBrowserPackage() + '}';
    }
}
