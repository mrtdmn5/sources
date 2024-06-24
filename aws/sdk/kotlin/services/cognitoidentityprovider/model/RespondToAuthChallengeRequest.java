package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RespondToAuthChallengeRequest.kt */
/* loaded from: classes.dex */
public final class RespondToAuthChallengeRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final ChallengeNameType challengeName;
    public final Map<String, String> challengeResponses;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final String session;
    public final UserContextDataType userContextData;

    /* compiled from: RespondToAuthChallengeRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public ChallengeNameType challengeName;
        public Map<String, String> challengeResponses;
        public String clientId;
        public Map<String, String> clientMetadata;
        public String session;
        public UserContextDataType userContextData;

        public final void analyticsMetadata(Function1<? super AnalyticsMetadataType.Builder, Unit> function1) {
            AnalyticsMetadataType.Builder builder = new AnalyticsMetadataType.Builder();
            function1.invoke(builder);
            this.analyticsMetadata = new AnalyticsMetadataType(builder);
        }

        public final void userContextData(Function1<? super UserContextDataType.Builder, Unit> function1) {
            UserContextDataType.Builder builder = new UserContextDataType.Builder();
            function1.invoke(builder);
            this.userContextData = new UserContextDataType(builder);
        }
    }

    public RespondToAuthChallengeRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.challengeName = builder.challengeName;
        this.challengeResponses = builder.challengeResponses;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.session = builder.session;
        this.userContextData = builder.userContextData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RespondToAuthChallengeRequest.class != obj.getClass()) {
            return false;
        }
        RespondToAuthChallengeRequest respondToAuthChallengeRequest = (RespondToAuthChallengeRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, respondToAuthChallengeRequest.analyticsMetadata) && Intrinsics.areEqual(this.challengeName, respondToAuthChallengeRequest.challengeName) && Intrinsics.areEqual(this.challengeResponses, respondToAuthChallengeRequest.challengeResponses) && Intrinsics.areEqual(this.clientId, respondToAuthChallengeRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, respondToAuthChallengeRequest.clientMetadata) && Intrinsics.areEqual(this.session, respondToAuthChallengeRequest.session) && Intrinsics.areEqual(this.userContextData, respondToAuthChallengeRequest.userContextData)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r24;
        int r25;
        int r0 = 0;
        AnalyticsMetadataType analyticsMetadataType = this.analyticsMetadata;
        if (analyticsMetadataType != null) {
            r1 = analyticsMetadataType.hashCode();
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
        Map<String, String> map = this.challengeResponses;
        if (map != null) {
            r22 = map.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        String str = this.clientId;
        if (str != null) {
            r23 = str.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        Map<String, String> map2 = this.clientMetadata;
        if (map2 != null) {
            r24 = map2.hashCode();
        } else {
            r24 = 0;
        }
        int r16 = (r15 + r24) * 31;
        String str2 = this.session;
        if (str2 != null) {
            r25 = str2.hashCode();
        } else {
            r25 = 0;
        }
        int r17 = (r16 + r25) * 31;
        UserContextDataType userContextDataType = this.userContextData;
        if (userContextDataType != null) {
            r0 = userContextDataType.hashCode();
        }
        return r17 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RespondToAuthChallengeRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("challengeName=" + this.challengeName + ',');
        sb.append("challengeResponses=" + this.challengeResponses + ',');
        sb.append("clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("session="), this.session, ',', sb, "userContextData=");
        m.append(this.userContextData);
        sb.append(m.toString());
        sb.append(")");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
