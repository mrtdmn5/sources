package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.options.AuthConfirmSignUpOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthConfirmSignUpOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthConfirmSignUpOptions extends AuthConfirmSignUpOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> clientMetadata;

    /* compiled from: AWSCognitoAuthConfirmSignUpOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthConfirmSignUpOptions.Builder<CognitoBuilder> {
        private Map<String, String> clientMetadata = EmptyMap.INSTANCE;

        public final CognitoBuilder clientMetadata(Map<String, String> clientMetadata) {
            Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
            this.clientMetadata = clientMetadata;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthConfirmSignUpOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthConfirmSignUpOptions.Builder
        public AWSCognitoAuthConfirmSignUpOptions build() {
            return new AWSCognitoAuthConfirmSignUpOptions(this.clientMetadata);
        }
    }

    /* compiled from: AWSCognitoAuthConfirmSignUpOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthConfirmSignUpOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthConfirmSignUpOptions(Map<String, String> clientMetadata) {
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        this.clientMetadata = clientMetadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthConfirmSignUpOptions copy$default(AWSCognitoAuthConfirmSignUpOptions aWSCognitoAuthConfirmSignUpOptions, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = aWSCognitoAuthConfirmSignUpOptions.clientMetadata;
        }
        return aWSCognitoAuthConfirmSignUpOptions.copy(map);
    }

    public final Map<String, String> component1() {
        return this.clientMetadata;
    }

    public final AWSCognitoAuthConfirmSignUpOptions copy(Map<String, String> clientMetadata) {
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        return new AWSCognitoAuthConfirmSignUpOptions(clientMetadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AWSCognitoAuthConfirmSignUpOptions) && Intrinsics.areEqual(this.clientMetadata, ((AWSCognitoAuthConfirmSignUpOptions) obj).clientMetadata)) {
            return true;
        }
        return false;
    }

    public final Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public int hashCode() {
        return this.clientMetadata.hashCode();
    }

    public String toString() {
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AWSCognitoAuthConfirmSignUpOptions(clientMetadata="), this.clientMetadata, ')');
    }
}
