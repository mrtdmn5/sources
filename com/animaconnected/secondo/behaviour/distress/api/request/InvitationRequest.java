package com.animaconnected.secondo.behaviour.distress.api.request;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class InvitationRequest {
    public static final int $stable = 0;
    private final String userId;

    public InvitationRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InvitationRequest copy$default(InvitationRequest invitationRequest, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = invitationRequest.userId;
        }
        return invitationRequest.copy(str);
    }

    public final String component1() {
        return this.userId;
    }

    public final InvitationRequest copy(String str) {
        return new InvitationRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof InvitationRequest) && Intrinsics.areEqual(this.userId, ((InvitationRequest) obj).userId)) {
            return true;
        }
        return false;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.userId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("InvitationRequest(userId="), this.userId, ')');
    }

    public InvitationRequest(String str) {
        this.userId = str;
    }

    public /* synthetic */ InvitationRequest(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? null : str);
    }
}
