package com.amplifyframework.auth.cognito;

import com.amplifyframework.auth.AWSAuthSessionInternal;
import com.amplifyframework.auth.AWSCognitoUserPoolTokens;
import com.amplifyframework.auth.AWSCredentials;
import com.amplifyframework.auth.result.AuthSessionResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSession.kt */
/* loaded from: classes.dex */
public final class AWSCognitoAuthSession extends AWSAuthSessionInternal {
    private final AuthSessionResult<AWSCredentials> awsCredentialsResult;
    private final AuthSessionResult<String> identityIdResult;
    private final boolean isSignedIn;
    private final AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult;
    private final AuthSessionResult<String> userSubResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWSCognitoAuthSession(boolean z, AuthSessionResult<String> identityIdResult, AuthSessionResult<AWSCredentials> awsCredentialsResult, AuthSessionResult<String> userSubResult, AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult) {
        super(z, identityIdResult, awsCredentialsResult, userSubResult, userPoolTokensResult);
        Intrinsics.checkNotNullParameter(identityIdResult, "identityIdResult");
        Intrinsics.checkNotNullParameter(awsCredentialsResult, "awsCredentialsResult");
        Intrinsics.checkNotNullParameter(userSubResult, "userSubResult");
        Intrinsics.checkNotNullParameter(userPoolTokensResult, "userPoolTokensResult");
        this.isSignedIn = z;
        this.identityIdResult = identityIdResult;
        this.awsCredentialsResult = awsCredentialsResult;
        this.userSubResult = userSubResult;
        this.userPoolTokensResult = userPoolTokensResult;
    }

    public static /* synthetic */ AWSCognitoAuthSession copy$default(AWSCognitoAuthSession aWSCognitoAuthSession, boolean z, AuthSessionResult authSessionResult, AuthSessionResult authSessionResult2, AuthSessionResult authSessionResult3, AuthSessionResult authSessionResult4, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            z = aWSCognitoAuthSession.getSignedIn();
        }
        if ((r9 & 2) != 0) {
            authSessionResult = aWSCognitoAuthSession.getIdentityIdResult();
        }
        AuthSessionResult authSessionResult5 = authSessionResult;
        if ((r9 & 4) != 0) {
            authSessionResult2 = aWSCognitoAuthSession.getAwsCredentialsResult();
        }
        AuthSessionResult authSessionResult6 = authSessionResult2;
        if ((r9 & 8) != 0) {
            authSessionResult3 = aWSCognitoAuthSession.getUserSubResult();
        }
        AuthSessionResult authSessionResult7 = authSessionResult3;
        if ((r9 & 16) != 0) {
            authSessionResult4 = aWSCognitoAuthSession.getUserPoolTokensResult();
        }
        return aWSCognitoAuthSession.copy(z, authSessionResult5, authSessionResult6, authSessionResult7, authSessionResult4);
    }

    public final boolean component1() {
        return getSignedIn();
    }

    public final AuthSessionResult<String> component2() {
        return getIdentityIdResult();
    }

    public final AuthSessionResult<AWSCredentials> component3() {
        return getAwsCredentialsResult();
    }

    public final AuthSessionResult<String> component4() {
        return getUserSubResult();
    }

    public final AuthSessionResult<AWSCognitoUserPoolTokens> component5() {
        return getUserPoolTokensResult();
    }

    public final AWSCognitoAuthSession copy(boolean z, AuthSessionResult<String> identityIdResult, AuthSessionResult<AWSCredentials> awsCredentialsResult, AuthSessionResult<String> userSubResult, AuthSessionResult<AWSCognitoUserPoolTokens> userPoolTokensResult) {
        Intrinsics.checkNotNullParameter(identityIdResult, "identityIdResult");
        Intrinsics.checkNotNullParameter(awsCredentialsResult, "awsCredentialsResult");
        Intrinsics.checkNotNullParameter(userSubResult, "userSubResult");
        Intrinsics.checkNotNullParameter(userPoolTokensResult, "userPoolTokensResult");
        return new AWSCognitoAuthSession(z, identityIdResult, awsCredentialsResult, userSubResult, userPoolTokensResult);
    }

    @Override // com.amplifyframework.auth.AuthSession
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSCognitoAuthSession)) {
            return false;
        }
        AWSCognitoAuthSession aWSCognitoAuthSession = (AWSCognitoAuthSession) obj;
        if (getSignedIn() == aWSCognitoAuthSession.getSignedIn() && Intrinsics.areEqual(getIdentityIdResult(), aWSCognitoAuthSession.getIdentityIdResult()) && Intrinsics.areEqual(getAwsCredentialsResult(), aWSCognitoAuthSession.getAwsCredentialsResult()) && Intrinsics.areEqual(getUserSubResult(), aWSCognitoAuthSession.getUserSubResult()) && Intrinsics.areEqual(getUserPoolTokensResult(), aWSCognitoAuthSession.getUserPoolTokensResult())) {
            return true;
        }
        return false;
    }

    @Override // com.amplifyframework.auth.AWSAuthSessionInternal
    public AuthSessionResult<AWSCredentials> getAwsCredentialsResult() {
        return this.awsCredentialsResult;
    }

    @Override // com.amplifyframework.auth.AWSAuthSessionInternal
    public AuthSessionResult<String> getIdentityIdResult() {
        return this.identityIdResult;
    }

    @Override // com.amplifyframework.auth.AWSAuthSessionInternal
    public boolean getSignedIn() {
        return this.isSignedIn;
    }

    @Override // com.amplifyframework.auth.AWSAuthSessionInternal
    public AuthSessionResult<AWSCognitoUserPoolTokens> getUserPoolTokensResult() {
        return this.userPoolTokensResult;
    }

    @Override // com.amplifyframework.auth.AWSAuthSessionInternal
    public AuthSessionResult<String> getUserSubResult() {
        return this.userSubResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    @Override // com.amplifyframework.auth.AuthSession
    public int hashCode() {
        boolean signedIn = getSignedIn();
        ?? r0 = signedIn;
        if (signedIn) {
            r0 = 1;
        }
        return getUserPoolTokensResult().hashCode() + ((getUserSubResult().hashCode() + ((getAwsCredentialsResult().hashCode() + ((getIdentityIdResult().hashCode() + (r0 * 31)) * 31)) * 31)) * 31);
    }

    @Override // com.amplifyframework.auth.AuthSession
    public String toString() {
        return "AWSCognitoAuthSession(isSignedIn=" + getSignedIn() + ", identityIdResult=" + getIdentityIdResult() + ", awsCredentialsResult=" + getAwsCredentialsResult() + ", userSubResult=" + getUserSubResult() + ", userPoolTokensResult=" + getUserPoolTokensResult() + ')';
    }
}
