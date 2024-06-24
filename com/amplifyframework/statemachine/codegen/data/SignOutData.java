package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignOutData.kt */
/* loaded from: classes.dex */
public final class SignOutData {
    private final String browserPackage;
    private final boolean bypassCancel;
    private final boolean globalSignOut;

    public SignOutData() {
        this(false, null, false, 7, null);
    }

    public static /* synthetic */ SignOutData copy$default(SignOutData signOutData, boolean z, String str, boolean z2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = signOutData.globalSignOut;
        }
        if ((r4 & 2) != 0) {
            str = signOutData.browserPackage;
        }
        if ((r4 & 4) != 0) {
            z2 = signOutData.bypassCancel;
        }
        return signOutData.copy(z, str, z2);
    }

    public final boolean component1() {
        return this.globalSignOut;
    }

    public final String component2() {
        return this.browserPackage;
    }

    public final boolean component3() {
        return this.bypassCancel;
    }

    public final SignOutData copy(boolean z, String str, boolean z2) {
        return new SignOutData(z, str, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignOutData)) {
            return false;
        }
        SignOutData signOutData = (SignOutData) obj;
        if (this.globalSignOut == signOutData.globalSignOut && Intrinsics.areEqual(this.browserPackage, signOutData.browserPackage) && this.bypassCancel == signOutData.bypassCancel) {
            return true;
        }
        return false;
    }

    public final String getBrowserPackage() {
        return this.browserPackage;
    }

    public final boolean getBypassCancel() {
        return this.bypassCancel;
    }

    public final boolean getGlobalSignOut() {
        return this.globalSignOut;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z = this.globalSignOut;
        int r1 = 1;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int r02 = r0 * 31;
        String str = this.browserPackage;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r03 = (r02 + hashCode) * 31;
        boolean z2 = this.bypassCancel;
        if (!z2) {
            r1 = z2 ? 1 : 0;
        }
        return r03 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SignOutData(globalSignOut=");
        sb.append(this.globalSignOut);
        sb.append(", browserPackage=");
        sb.append(this.browserPackage);
        sb.append(", bypassCancel=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.bypassCancel, ')');
    }

    public SignOutData(boolean z, String str, boolean z2) {
        this.globalSignOut = z;
        this.browserPackage = str;
        this.bypassCancel = z2;
    }

    public /* synthetic */ SignOutData(boolean z, String str, boolean z2, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? false : z, (r5 & 2) != 0 ? null : str, (r5 & 4) != 0 ? false : z2);
    }
}
