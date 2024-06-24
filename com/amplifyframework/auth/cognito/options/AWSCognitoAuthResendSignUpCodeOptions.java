package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.options.AuthResendSignUpCodeOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthResendSignUpCodeOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthResendSignUpCodeOptions extends AuthResendSignUpCodeOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> metadata;

    /* compiled from: AWSCognitoAuthResendSignUpCodeOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthResendSignUpCodeOptions.Builder<CognitoBuilder> {
        private Map<String, String> metadata = EmptyMap.INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthResendSignUpCodeOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder metadata(Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthResendSignUpCodeOptions.Builder
        public AWSCognitoAuthResendSignUpCodeOptions build() {
            return new AWSCognitoAuthResendSignUpCodeOptions(this.metadata);
        }
    }

    /* compiled from: AWSCognitoAuthResendSignUpCodeOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthResendSignUpCodeOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthResendSignUpCodeOptions(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.metadata = metadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthResendSignUpCodeOptions copy$default(AWSCognitoAuthResendSignUpCodeOptions aWSCognitoAuthResendSignUpCodeOptions, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = aWSCognitoAuthResendSignUpCodeOptions.metadata;
        }
        return aWSCognitoAuthResendSignUpCodeOptions.copy(map);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final AWSCognitoAuthResendSignUpCodeOptions copy(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new AWSCognitoAuthResendSignUpCodeOptions(metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AWSCognitoAuthResendSignUpCodeOptions) && Intrinsics.areEqual(this.metadata, ((AWSCognitoAuthResendSignUpCodeOptions) obj).metadata)) {
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
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AWSCognitoAuthResendSignUpCodeOptions(metadata="), this.metadata, ')');
    }
}
