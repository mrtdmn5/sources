package com.animaconnected.secondo.behaviour.distress.api.request;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class RegisterTokenRequest {
    public static final int $stable = 0;
    private final String token;
    private final String userId;

    public RegisterTokenRequest(String userId, String token) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        this.userId = userId;
        this.token = token;
    }

    public static /* synthetic */ RegisterTokenRequest copy$default(RegisterTokenRequest registerTokenRequest, String str, String str2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = registerTokenRequest.userId;
        }
        if ((r3 & 2) != 0) {
            str2 = registerTokenRequest.token;
        }
        return registerTokenRequest.copy(str, str2);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.token;
    }

    public final RegisterTokenRequest copy(String userId, String token) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(token, "token");
        return new RegisterTokenRequest(userId, token);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterTokenRequest)) {
            return false;
        }
        RegisterTokenRequest registerTokenRequest = (RegisterTokenRequest) obj;
        if (Intrinsics.areEqual(this.userId, registerTokenRequest.userId) && Intrinsics.areEqual(this.token, registerTokenRequest.token)) {
            return true;
        }
        return false;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.token.hashCode() + (this.userId.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RegisterTokenRequest(userId=");
        sb.append(this.userId);
        sb.append(", token=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.token, ')');
    }
}
