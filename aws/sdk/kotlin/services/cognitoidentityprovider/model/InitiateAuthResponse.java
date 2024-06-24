package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.model.Credentials$$ExternalSyntheticOutline0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitiateAuthResponse.kt */
/* loaded from: classes.dex */
public final class InitiateAuthResponse {
    public final AuthenticationResultType authenticationResult;
    public final ChallengeNameType challengeName;
    public final Map<String, String> challengeParameters;
    public final String session;

    /* compiled from: InitiateAuthResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AuthenticationResultType authenticationResult;
        public ChallengeNameType challengeName;
        public Map<String, String> challengeParameters;
        public String session;
    }

    public InitiateAuthResponse(Builder builder) {
        this.authenticationResult = builder.authenticationResult;
        this.challengeName = builder.challengeName;
        this.challengeParameters = builder.challengeParameters;
        this.session = builder.session;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InitiateAuthResponse.class != obj.getClass()) {
            return false;
        }
        InitiateAuthResponse initiateAuthResponse = (InitiateAuthResponse) obj;
        if (Intrinsics.areEqual(this.authenticationResult, initiateAuthResponse.authenticationResult) && Intrinsics.areEqual(this.challengeName, initiateAuthResponse.challengeName) && Intrinsics.areEqual(this.challengeParameters, initiateAuthResponse.challengeParameters) && Intrinsics.areEqual(this.session, initiateAuthResponse.session)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r0 = 0;
        AuthenticationResultType authenticationResultType = this.authenticationResult;
        if (authenticationResultType != null) {
            r1 = authenticationResultType.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        ChallengeNameType challengeNameType = this.challengeName;
        if (challengeNameType != null) {
            r2 = challengeNameType.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Map<String, String> map = this.challengeParameters;
        if (map != null) {
            r22 = map.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        String str = this.session;
        if (str != null) {
            r0 = str.hashCode();
        }
        return r14 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InitiateAuthResponse(");
        sb.append("authenticationResult=" + this.authenticationResult + ',');
        sb.append("challengeName=" + this.challengeName + ',');
        sb.append("challengeParameters=" + this.challengeParameters + ',');
        return Credentials$$ExternalSyntheticOutline0.m(new StringBuilder("session="), this.session, sb, ")", "StringBuilder().apply(builderAction).toString()");
    }
}
