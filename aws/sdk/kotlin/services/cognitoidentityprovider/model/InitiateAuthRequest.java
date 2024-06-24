package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.UserContextDataType;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitiateAuthRequest.kt */
/* loaded from: classes.dex */
public final class InitiateAuthRequest {
    public final AnalyticsMetadataType analyticsMetadata;
    public final AuthFlowType authFlow;
    public final Map<String, String> authParameters;
    public final String clientId;
    public final Map<String, String> clientMetadata;
    public final UserContextDataType userContextData;

    /* compiled from: InitiateAuthRequest.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public AnalyticsMetadataType analyticsMetadata;
        public AuthFlowType authFlow;
        public Map<String, String> authParameters;
        public String clientId;
        public Map<String, String> clientMetadata;
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

    public InitiateAuthRequest(Builder builder) {
        this.analyticsMetadata = builder.analyticsMetadata;
        this.authFlow = builder.authFlow;
        this.authParameters = builder.authParameters;
        this.clientId = builder.clientId;
        this.clientMetadata = builder.clientMetadata;
        this.userContextData = builder.userContextData;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InitiateAuthRequest.class != obj.getClass()) {
            return false;
        }
        InitiateAuthRequest initiateAuthRequest = (InitiateAuthRequest) obj;
        if (Intrinsics.areEqual(this.analyticsMetadata, initiateAuthRequest.analyticsMetadata) && Intrinsics.areEqual(this.authFlow, initiateAuthRequest.authFlow) && Intrinsics.areEqual(this.authParameters, initiateAuthRequest.authParameters) && Intrinsics.areEqual(this.clientId, initiateAuthRequest.clientId) && Intrinsics.areEqual(this.clientMetadata, initiateAuthRequest.clientMetadata) && Intrinsics.areEqual(this.userContextData, initiateAuthRequest.userContextData)) {
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
        int r0 = 0;
        AnalyticsMetadataType analyticsMetadataType = this.analyticsMetadata;
        if (analyticsMetadataType != null) {
            r1 = analyticsMetadataType.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        AuthFlowType authFlowType = this.authFlow;
        if (authFlowType != null) {
            r2 = authFlowType.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        Map<String, String> map = this.authParameters;
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
        UserContextDataType userContextDataType = this.userContextData;
        if (userContextDataType != null) {
            r0 = userContextDataType.hashCode();
        }
        return r16 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InitiateAuthRequest(");
        sb.append("analyticsMetadata=" + this.analyticsMetadata + ',');
        sb.append("authFlow=" + this.authFlow + ',');
        sb.append("authParameters=*** Sensitive Data Redacted ***,clientId=*** Sensitive Data Redacted ***,");
        sb.append("clientMetadata=" + this.clientMetadata + ',');
        StringBuilder sb2 = new StringBuilder("userContextData=");
        sb2.append(this.userContextData);
        sb.append(sb2.toString());
        sb.append(")");
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
