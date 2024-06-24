package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthResendUserAttributeConfirmationCodeOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthResendUserAttributeConfirmationCodeOptions extends AuthResendUserAttributeConfirmationCodeOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> metadata;

    /* compiled from: AWSCognitoAuthResendUserAttributeConfirmationCodeOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthResendUserAttributeConfirmationCodeOptions.Builder<CognitoBuilder> {
        private Map<String, String> metadata = EmptyMap.INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder metadata(Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthResendUserAttributeConfirmationCodeOptions.Builder
        public AWSCognitoAuthResendUserAttributeConfirmationCodeOptions build() {
            return new AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(this.metadata);
        }
    }

    /* compiled from: AWSCognitoAuthResendUserAttributeConfirmationCodeOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthResendUserAttributeConfirmationCodeOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.metadata = metadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthResendUserAttributeConfirmationCodeOptions copy$default(AWSCognitoAuthResendUserAttributeConfirmationCodeOptions aWSCognitoAuthResendUserAttributeConfirmationCodeOptions, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = aWSCognitoAuthResendUserAttributeConfirmationCodeOptions.metadata;
        }
        return aWSCognitoAuthResendUserAttributeConfirmationCodeOptions.copy(map);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final AWSCognitoAuthResendUserAttributeConfirmationCodeOptions copy(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) && Intrinsics.areEqual(this.metadata, ((AWSCognitoAuthResendUserAttributeConfirmationCodeOptions) obj).metadata)) {
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
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AWSCognitoAuthResendUserAttributeConfirmationCodeOptions(metadata="), this.metadata, ')');
    }
}
