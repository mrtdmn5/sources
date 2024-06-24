package com.animaconnected.secondo.behaviour.distress.api.request;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Requests.kt */
/* loaded from: classes3.dex */
public final class Invitation {
    public static final int $stable = 0;
    private final String invitationToken;

    public Invitation(String str) {
        this.invitationToken = str;
    }

    public static /* synthetic */ Invitation copy$default(Invitation invitation, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = invitation.invitationToken;
        }
        return invitation.copy(str);
    }

    public final String component1() {
        return this.invitationToken;
    }

    public final Invitation copy(String str) {
        return new Invitation(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Invitation) && Intrinsics.areEqual(this.invitationToken, ((Invitation) obj).invitationToken)) {
            return true;
        }
        return false;
    }

    public final String getInvitationToken() {
        return this.invitationToken;
    }

    public int hashCode() {
        String str = this.invitationToken;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Invitation(invitationToken="), this.invitationToken, ')');
    }
}
