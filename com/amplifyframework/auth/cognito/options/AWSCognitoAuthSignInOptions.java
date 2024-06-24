package com.amplifyframework.auth.cognito.options;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.util.Immutable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AWSCognitoAuthSignInOptions extends AuthSignInOptions {
    private final AuthFlowType authFlowType;
    private final Map<String, String> metadata;

    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthSignInOptions.Builder<CognitoBuilder> {
        private AuthFlowType authFlowType;
        private final Map<String, String> metadata = new HashMap();

        public CognitoBuilder authFlowType(AuthFlowType authFlowType) {
            this.authFlowType = authFlowType;
            return getThis();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthSignInOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public CognitoBuilder metadata(Map<String, String> map) {
            Objects.requireNonNull(map);
            this.metadata.clear();
            this.metadata.putAll(map);
            return getThis();
        }

        @Override // com.amplifyframework.auth.options.AuthSignInOptions.Builder
        public AWSCognitoAuthSignInOptions build() {
            return new AWSCognitoAuthSignInOptions(Immutable.of(this.metadata), this.authFlowType);
        }
    }

    public AWSCognitoAuthSignInOptions(Map<String, String> map, AuthFlowType authFlowType) {
        this.metadata = map;
        this.authFlowType = authFlowType;
    }

    public static CognitoBuilder builder() {
        return new CognitoBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AWSCognitoAuthSignInOptions.class != obj.getClass()) {
            return false;
        }
        AWSCognitoAuthSignInOptions aWSCognitoAuthSignInOptions = (AWSCognitoAuthSignInOptions) obj;
        if (ObjectsCompat$Api19Impl.equals(getMetadata(), aWSCognitoAuthSignInOptions.getMetadata()) && ObjectsCompat$Api19Impl.equals(getAuthFlowType(), aWSCognitoAuthSignInOptions.getAuthFlowType())) {
            return true;
        }
        return false;
    }

    public AuthFlowType getAuthFlowType() {
        return this.authFlowType;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getMetadata(), getAuthFlowType());
    }

    public String toString() {
        return "AWSCognitoAuthSignInOptions{metadata=" + getMetadata() + ", authFlowType=" + getAuthFlowType() + '}';
    }
}
