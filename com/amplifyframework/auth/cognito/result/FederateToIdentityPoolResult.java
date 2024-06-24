package com.amplifyframework.auth.cognito.result;

import com.amplifyframework.auth.AWSTemporaryCredentials;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FederateToIdentityPoolResult.kt */
/* loaded from: classes.dex */
public final class FederateToIdentityPoolResult {
    private final AWSTemporaryCredentials credentials;
    private final String identityId;

    public FederateToIdentityPoolResult(String identityId, AWSTemporaryCredentials credentials) {
        Intrinsics.checkNotNullParameter(identityId, "identityId");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        this.identityId = identityId;
        this.credentials = credentials;
    }

    public static /* synthetic */ FederateToIdentityPoolResult copy$default(FederateToIdentityPoolResult federateToIdentityPoolResult, String str, AWSTemporaryCredentials aWSTemporaryCredentials, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = federateToIdentityPoolResult.identityId;
        }
        if ((r3 & 2) != 0) {
            aWSTemporaryCredentials = federateToIdentityPoolResult.credentials;
        }
        return federateToIdentityPoolResult.copy(str, aWSTemporaryCredentials);
    }

    public final String component1() {
        return this.identityId;
    }

    public final AWSTemporaryCredentials component2() {
        return this.credentials;
    }

    public final FederateToIdentityPoolResult copy(String identityId, AWSTemporaryCredentials credentials) {
        Intrinsics.checkNotNullParameter(identityId, "identityId");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        return new FederateToIdentityPoolResult(identityId, credentials);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FederateToIdentityPoolResult)) {
            return false;
        }
        FederateToIdentityPoolResult federateToIdentityPoolResult = (FederateToIdentityPoolResult) obj;
        if (Intrinsics.areEqual(this.identityId, federateToIdentityPoolResult.identityId) && Intrinsics.areEqual(this.credentials, federateToIdentityPoolResult.credentials)) {
            return true;
        }
        return false;
    }

    public final AWSTemporaryCredentials getCredentials() {
        return this.credentials;
    }

    public final String getIdentityId() {
        return this.identityId;
    }

    public int hashCode() {
        return this.credentials.hashCode() + (this.identityId.hashCode() * 31);
    }

    public String toString() {
        return "FederateToIdentityPoolResult(identityId=" + this.identityId + ", credentials=" + this.credentials + ')';
    }
}
