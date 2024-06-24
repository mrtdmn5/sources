package com.animaconnected.firebase.config;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StatusDiagEnabledParams.kt */
/* loaded from: classes.dex */
public final class StatusDiagEnabledParams {
    private final boolean dfu;
    private final boolean fota;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StatusDiagEnabledParams() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.firebase.config.StatusDiagEnabledParams.<init>():void");
    }

    public static /* synthetic */ StatusDiagEnabledParams copy$default(StatusDiagEnabledParams statusDiagEnabledParams, boolean z, boolean z2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            z = statusDiagEnabledParams.fota;
        }
        if ((r3 & 2) != 0) {
            z2 = statusDiagEnabledParams.dfu;
        }
        return statusDiagEnabledParams.copy(z, z2);
    }

    public final boolean component1() {
        return this.fota;
    }

    public final boolean component2() {
        return this.dfu;
    }

    public final StatusDiagEnabledParams copy(boolean z, boolean z2) {
        return new StatusDiagEnabledParams(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusDiagEnabledParams)) {
            return false;
        }
        StatusDiagEnabledParams statusDiagEnabledParams = (StatusDiagEnabledParams) obj;
        if (this.fota == statusDiagEnabledParams.fota && this.dfu == statusDiagEnabledParams.dfu) {
            return true;
        }
        return false;
    }

    public final boolean getDfu() {
        return this.dfu;
    }

    public final boolean getFota() {
        return this.fota;
    }

    public int hashCode() {
        return Boolean.hashCode(this.dfu) + (Boolean.hashCode(this.fota) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatusDiagEnabledParams(fota=");
        sb.append(this.fota);
        sb.append(", dfu=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.dfu, ')');
    }

    public StatusDiagEnabledParams(boolean z, boolean z2) {
        this.fota = z;
        this.dfu = z2;
    }

    public /* synthetic */ StatusDiagEnabledParams(boolean z, boolean z2, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? true : z, (r4 & 2) != 0 ? true : z2);
    }
}
