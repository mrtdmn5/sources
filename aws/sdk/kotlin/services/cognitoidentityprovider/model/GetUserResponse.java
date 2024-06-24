package aws.sdk.kotlin.services.cognitoidentityprovider.model;

import aws.sdk.kotlin.services.cognitoidentity.endpoints.EndpointParameters$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetUserResponse.kt */
/* loaded from: classes.dex */
public final class GetUserResponse {
    public final List<MfaOptionType> mfaOptions;
    public final String preferredMfaSetting;
    public final List<AttributeType> userAttributes;
    public final List<String> userMfaSettingList;
    public final String username;

    /* compiled from: GetUserResponse.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        public List<MfaOptionType> mfaOptions;
        public String preferredMfaSetting;
        public List<AttributeType> userAttributes;
        public List<String> userMfaSettingList;
        public String username;
    }

    public GetUserResponse(Builder builder) {
        this.mfaOptions = builder.mfaOptions;
        this.preferredMfaSetting = builder.preferredMfaSetting;
        this.userAttributes = builder.userAttributes;
        this.userMfaSettingList = builder.userMfaSettingList;
        this.username = builder.username;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GetUserResponse.class != obj.getClass()) {
            return false;
        }
        GetUserResponse getUserResponse = (GetUserResponse) obj;
        if (Intrinsics.areEqual(this.mfaOptions, getUserResponse.mfaOptions) && Intrinsics.areEqual(this.preferredMfaSetting, getUserResponse.preferredMfaSetting) && Intrinsics.areEqual(this.userAttributes, getUserResponse.userAttributes) && Intrinsics.areEqual(this.userMfaSettingList, getUserResponse.userMfaSettingList) && Intrinsics.areEqual(this.username, getUserResponse.username)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r2;
        int r22;
        int r23;
        int r0 = 0;
        List<MfaOptionType> list = this.mfaOptions;
        if (list != null) {
            r1 = list.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        String str = this.preferredMfaSetting;
        if (str != null) {
            r2 = str.hashCode();
        } else {
            r2 = 0;
        }
        int r13 = (r12 + r2) * 31;
        List<AttributeType> list2 = this.userAttributes;
        if (list2 != null) {
            r22 = list2.hashCode();
        } else {
            r22 = 0;
        }
        int r14 = (r13 + r22) * 31;
        List<String> list3 = this.userMfaSettingList;
        if (list3 != null) {
            r23 = list3.hashCode();
        } else {
            r23 = 0;
        }
        int r15 = (r14 + r23) * 31;
        String str2 = this.username;
        if (str2 != null) {
            r0 = str2.hashCode();
        }
        return r15 + r0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GetUserResponse(");
        sb.append("mfaOptions=" + this.mfaOptions + ',');
        StringBuilder m = EndpointParameters$$ExternalSyntheticOutline0.m(new StringBuilder("preferredMfaSetting="), this.preferredMfaSetting, ',', sb, "userAttributes=");
        m.append(this.userAttributes);
        m.append(',');
        sb.append(m.toString());
        sb.append("userMfaSettingList=" + this.userMfaSettingList + ',');
        sb.append("username=*** Sensitive Data Redacted ***)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
