package com.amplifyframework.auth.cognito.options;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FederateToIdentityPoolOptions.kt */
/* loaded from: classes.dex */
public final class FederateToIdentityPoolOptions {
    public static final Companion Companion = new Companion(null);
    private final String developerProvidedIdentityId;

    /* compiled from: FederateToIdentityPoolOptions.kt */
    /* loaded from: classes.dex */
    public static final class CognitoBuilder {
        private String developerProvidedIdentityId;

        public final FederateToIdentityPoolOptions build() {
            return new FederateToIdentityPoolOptions(this.developerProvidedIdentityId);
        }

        public final CognitoBuilder developerProvidedIdentityId(String developerProvidedIdentityId) {
            Intrinsics.checkNotNullParameter(developerProvidedIdentityId, "developerProvidedIdentityId");
            this.developerProvidedIdentityId = developerProvidedIdentityId;
            return this;
        }
    }

    /* compiled from: FederateToIdentityPoolOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CognitoBuilder builder() {
            return new CognitoBuilder();
        }

        public final FederateToIdentityPoolOptions invoke(Function1<? super CognitoBuilder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            CognitoBuilder cognitoBuilder = new CognitoBuilder();
            block.invoke(cognitoBuilder);
            return cognitoBuilder.build();
        }

        private Companion() {
        }
    }

    public FederateToIdentityPoolOptions(String str) {
        this.developerProvidedIdentityId = str;
    }

    public static final CognitoBuilder builder() {
        return Companion.builder();
    }

    public static /* synthetic */ FederateToIdentityPoolOptions copy$default(FederateToIdentityPoolOptions federateToIdentityPoolOptions, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = federateToIdentityPoolOptions.developerProvidedIdentityId;
        }
        return federateToIdentityPoolOptions.copy(str);
    }

    public final String component1() {
        return this.developerProvidedIdentityId;
    }

    public final FederateToIdentityPoolOptions copy(String str) {
        return new FederateToIdentityPoolOptions(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FederateToIdentityPoolOptions) && Intrinsics.areEqual(this.developerProvidedIdentityId, ((FederateToIdentityPoolOptions) obj).developerProvidedIdentityId)) {
            return true;
        }
        return false;
    }

    public final String getDeveloperProvidedIdentityId() {
        return this.developerProvidedIdentityId;
    }

    public int hashCode() {
        String str = this.developerProvidedIdentityId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FederateToIdentityPoolOptions(developerProvidedIdentityId="), this.developerProvidedIdentityId, ')');
    }
}
