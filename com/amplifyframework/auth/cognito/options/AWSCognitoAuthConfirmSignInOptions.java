package com.amplifyframework.auth.cognito.options;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.options.AuthConfirmSignInOptions;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthConfirmSignInOptions.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthConfirmSignInOptions extends AuthConfirmSignInOptions {
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> metadata;
    private final List<AuthUserAttribute> userAttributes;

    /* compiled from: AWSCognitoAuthConfirmSignInOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder extends AuthConfirmSignInOptions.Builder<CognitoBuilder> {
        private Map<String, String> metadata = EmptyMap.INSTANCE;
        private List<AuthUserAttribute> userAttributes = EmptyList.INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.auth.options.AuthConfirmSignInOptions.Builder
        public CognitoBuilder getThis() {
            return this;
        }

        public final CognitoBuilder metadata(Map<String, String> metadata) {
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            this.metadata = metadata;
            return this;
        }

        public final CognitoBuilder userAttributes(List<AuthUserAttribute> userAttributes) {
            Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
            this.userAttributes = userAttributes;
            return this;
        }

        @Override // com.amplifyframework.auth.options.AuthConfirmSignInOptions.Builder
        public AWSCognitoAuthConfirmSignInOptions build() {
            return new AWSCognitoAuthConfirmSignInOptions(this.metadata, this.userAttributes);
        }
    }

    /* compiled from: AWSCognitoAuthConfirmSignInOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final AWSCognitoAuthConfirmSignInOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public AWSCognitoAuthConfirmSignInOptions(Map<String, String> metadata, List<AuthUserAttribute> userAttributes) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        this.metadata = metadata;
        this.userAttributes = userAttributes;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AWSCognitoAuthConfirmSignInOptions copy$default(AWSCognitoAuthConfirmSignInOptions aWSCognitoAuthConfirmSignInOptions, Map map, List list, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            map = aWSCognitoAuthConfirmSignInOptions.metadata;
        }
        if ((r3 & 2) != 0) {
            list = aWSCognitoAuthConfirmSignInOptions.userAttributes;
        }
        return aWSCognitoAuthConfirmSignInOptions.copy(map, list);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final List<AuthUserAttribute> component2() {
        return this.userAttributes;
    }

    public final AWSCognitoAuthConfirmSignInOptions copy(Map<String, String> metadata, List<AuthUserAttribute> userAttributes) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
        return new AWSCognitoAuthConfirmSignInOptions(metadata, userAttributes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSCognitoAuthConfirmSignInOptions)) {
            return false;
        }
        AWSCognitoAuthConfirmSignInOptions aWSCognitoAuthConfirmSignInOptions = (AWSCognitoAuthConfirmSignInOptions) obj;
        if (Intrinsics.areEqual(this.metadata, aWSCognitoAuthConfirmSignInOptions.metadata) && Intrinsics.areEqual(this.userAttributes, aWSCognitoAuthConfirmSignInOptions.userAttributes)) {
            return true;
        }
        return false;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final List<AuthUserAttribute> getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        return this.userAttributes.hashCode() + (this.metadata.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AWSCognitoAuthConfirmSignInOptions(metadata=");
        sb.append(this.metadata);
        sb.append(", userAttributes=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.userAttributes, ')');
    }
}
