package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.options.AuthResetPasswordOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthResetPasswordOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthResetPasswordOptions extends AuthResetPasswordOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> metadata;

    /* compiled from: AWSCognitoAuthResetPasswordOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthResetPasswordOptions.Builder<CognitoBuilder> {
        private Map<String, String> metadata = EmptyMap.INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthResetPasswordOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder metadata(Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthResetPasswordOptions.Builder
        public AWSCognitoAuthResetPasswordOptions build() {
            return new AWSCognitoAuthResetPasswordOptions(this.metadata);
        }
    }

    /* compiled from: AWSCognitoAuthResetPasswordOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthResetPasswordOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthResetPasswordOptions(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.metadata = metadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthResetPasswordOptions copy$default(AWSCognitoAuthResetPasswordOptions aWSCognitoAuthResetPasswordOptions, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = aWSCognitoAuthResetPasswordOptions.metadata;
        }
        return aWSCognitoAuthResetPasswordOptions.copy(map);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final AWSCognitoAuthResetPasswordOptions copy(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new AWSCognitoAuthResetPasswordOptions(metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AWSCognitoAuthResetPasswordOptions) && Intrinsics.areEqual(this.metadata, ((AWSCognitoAuthResetPasswordOptions) obj).metadata)) {
            return true;
        }
        return false;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return this.metadata.hashCode();
    }

    public String toString() {
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AWSCognitoAuthResetPasswordOptions(metadata="), this.metadata, ')');
    }
}
