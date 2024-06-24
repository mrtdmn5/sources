package com.amplifyframework.auth.cognito.options;

import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSignUpOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthSignUpOptions extends AuthSignUpOptions {
    public static final Companion Companion = new Companion(null);
    private final List<AuthUserAttribute> attributes;
    private final Map<String, String> clientMetadata;
    private final Map<String, String> validationData;

    /* compiled from: AWSCognitoAuthSignUpOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthSignUpOptions.Builder<CognitoBuilder> {
        private Map<String, String> clientMetadata;
        private Map<String, String> validationData;

        public CognitoBuilder() {
            EmptyMap emptyMap = EmptyMap.INSTANCE;
            this.validationData = emptyMap;
            this.clientMetadata = emptyMap;
        }

        public final CognitoBuilder clientMetadata(Map<String, String> clientMetadata) {
            Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
            this.clientMetadata = clientMetadata;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthSignUpOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder validationData(Map<String, String> validationData) {
            Intrinsics.checkNotNullParameter(validationData, "validationData");
            this.validationData = validationData;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthSignUpOptions.Builder
        public AWSCognitoAuthSignUpOptions build() {
            List<AuthUserAttribute> userAttributes = super.getUserAttributes();
            Intrinsics.checkNotNullExpressionValue(userAttributes, "super.getUserAttributes()");
            return new AWSCognitoAuthSignUpOptions(userAttributes, this.validationData, this.clientMetadata);
        }
    }

    /* compiled from: AWSCognitoAuthSignUpOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthSignUpOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthSignUpOptions(List<AuthUserAttribute> attributes, Map<String, String> validationData, Map<String, String> clientMetadata) {
        super(attributes);
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(validationData, "validationData");
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        this.attributes = attributes;
        this.validationData = validationData;
        this.clientMetadata = clientMetadata;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    private final List<AuthUserAttribute> component1() {
        return this.attributes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthSignUpOptions copy$default(AWSCognitoAuthSignUpOptions aWSCognitoAuthSignUpOptions, List list, Map map, Map map2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            list = aWSCognitoAuthSignUpOptions.attributes;
        }
        if ((r4 & 2) != 0) {
            map = aWSCognitoAuthSignUpOptions.validationData;
        }
        if ((r4 & 4) != 0) {
            map2 = aWSCognitoAuthSignUpOptions.clientMetadata;
        }
        return aWSCognitoAuthSignUpOptions.copy(list, map, map2);
    }

    public final Map<String, String> component2() {
        return this.validationData;
    }

    public final Map<String, String> component3() {
        return this.clientMetadata;
    }

    public final AWSCognitoAuthSignUpOptions copy(List<AuthUserAttribute> attributes, Map<String, String> validationData, Map<String, String> clientMetadata) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(validationData, "validationData");
        Intrinsics.checkNotNullParameter(clientMetadata, "clientMetadata");
        return new AWSCognitoAuthSignUpOptions(attributes, validationData, clientMetadata);
    }

    @Override // com.amplifyframework.auth.options.AuthSignUpOptions
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSCognitoAuthSignUpOptions)) {
            return false;
        }
        AWSCognitoAuthSignUpOptions aWSCognitoAuthSignUpOptions = (AWSCognitoAuthSignUpOptions) obj;
        if (Intrinsics.areEqual(this.attributes, aWSCognitoAuthSignUpOptions.attributes) && Intrinsics.areEqual(this.validationData, aWSCognitoAuthSignUpOptions.validationData) && Intrinsics.areEqual(this.clientMetadata, aWSCognitoAuthSignUpOptions.clientMetadata)) {
            return true;
        }
        return false;
    }

    public final Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public final Map<String, String> getValidationData() {
        return this.validationData;
    }

    @Override // com.amplifyframework.auth.options.AuthSignUpOptions
    public int hashCode() {
        return this.clientMetadata.hashCode() + ((this.validationData.hashCode() + (this.attributes.hashCode() * 31)) * 31);
    }

    @Override // com.amplifyframework.auth.options.AuthSignUpOptions
    public String toString() {
        StringBuilder sb = new StringBuilder("AWSCognitoAuthSignUpOptions(attributes=");
        sb.append(this.attributes);
        sb.append(", validationData=");
        sb.append(this.validationData);
        sb.append(", clientMetadata=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.clientMetadata, ')');
    }
}
