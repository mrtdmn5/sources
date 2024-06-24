package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthUpdateUserAttributeOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthUpdateUserAttributeOptions extends AuthUpdateUserAttributeOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> metadata;

    /* compiled from: AWSCognitoAuthUpdateUserAttributeOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthUpdateUserAttributeOptions.Builder<CognitoBuilder> {
        private Map<String, String> metadata = EmptyMap.INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder metadata(Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthUpdateUserAttributeOptions.Builder
        public AWSCognitoAuthUpdateUserAttributeOptions build() {
            return new AWSCognitoAuthUpdateUserAttributeOptions(this.metadata);
        }
    }

    /* compiled from: AWSCognitoAuthUpdateUserAttributeOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthUpdateUserAttributeOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthUpdateUserAttributeOptions(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.metadata = metadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthUpdateUserAttributeOptions copy$default(AWSCognitoAuthUpdateUserAttributeOptions aWSCognitoAuthUpdateUserAttributeOptions, Map map, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            map = aWSCognitoAuthUpdateUserAttributeOptions.metadata;
        }
        return aWSCognitoAuthUpdateUserAttributeOptions.copy(map);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final AWSCognitoAuthUpdateUserAttributeOptions copy(Map<String, String> metadata) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new AWSCognitoAuthUpdateUserAttributeOptions(metadata);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AWSCognitoAuthUpdateUserAttributeOptions) && Intrinsics.areEqual(this.metadata, ((AWSCognitoAuthUpdateUserAttributeOptions) obj).metadata)) {
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
        return AwsProfile$$ExternalSyntheticOutline0.m(new StringBuilder("AWSCognitoAuthUpdateUserAttributeOptions(metadata="), this.metadata, ')');
    }
}
