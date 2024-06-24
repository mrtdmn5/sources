package com.amplifyframework.auth;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoUserPoolTokens.kt */
/* loaded from: classes.dex */
public final class AWSCognitoUserPoolTokens {
    private final String accessToken;
    private final String idToken;
    private final String refreshToken;

    public AWSCognitoUserPoolTokens(String str, String str2, String str3) {
        this.accessToken = str;
        this.idToken = str2;
        this.refreshToken = str3;
    }

    public static /* synthetic */ AWSCognitoUserPoolTokens copy$default(AWSCognitoUserPoolTokens aWSCognitoUserPoolTokens, String str, String str2, String str3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = aWSCognitoUserPoolTokens.accessToken;
        }
        if ((r4 & 2) != 0) {
            str2 = aWSCognitoUserPoolTokens.idToken;
        }
        if ((r4 & 4) != 0) {
            str3 = aWSCognitoUserPoolTokens.refreshToken;
        }
        return aWSCognitoUserPoolTokens.copy(str, str2, str3);
    }

    public final String component1() {
        return this.accessToken;
    }

    public final String component2() {
        return this.idToken;
    }

    public final String component3() {
        return this.refreshToken;
    }

    public final AWSCognitoUserPoolTokens copy(String str, String str2, String str3) {
        return new AWSCognitoUserPoolTokens(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AWSCognitoUserPoolTokens)) {
            return false;
        }
        AWSCognitoUserPoolTokens aWSCognitoUserPoolTokens = (AWSCognitoUserPoolTokens) obj;
        if (Intrinsics.areEqual(this.accessToken, aWSCognitoUserPoolTokens.accessToken) && Intrinsics.areEqual(this.idToken, aWSCognitoUserPoolTokens.idToken) && Intrinsics.areEqual(this.refreshToken, aWSCognitoUserPoolTokens.refreshToken)) {
            return true;
        }
        return false;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        String str = this.accessToken;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        String str2 = this.idToken;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str3 = this.refreshToken;
        if (str3 != null) {
            r1 = str3.hashCode();
        }
        return r02 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AWSCognitoUserPoolTokens(accessToken=");
        sb.append(this.accessToken);
        sb.append(", idToken=");
        sb.append(this.idToken);
        sb.append(", refreshToken=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.refreshToken, ')');
    }
}
