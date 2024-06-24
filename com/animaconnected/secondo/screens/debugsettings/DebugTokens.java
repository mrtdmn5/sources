package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugTokens {
    public static final int $stable = 0;
    private final String amplifyAccess;
    private final String cognito;
    private final String firebase;
    private final String poolId;

    public DebugTokens() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DebugTokens copy$default(DebugTokens debugTokens, String str, String str2, String str3, String str4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = debugTokens.poolId;
        }
        if ((r5 & 2) != 0) {
            str2 = debugTokens.firebase;
        }
        if ((r5 & 4) != 0) {
            str3 = debugTokens.cognito;
        }
        if ((r5 & 8) != 0) {
            str4 = debugTokens.amplifyAccess;
        }
        return debugTokens.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.poolId;
    }

    public final String component2() {
        return this.firebase;
    }

    public final String component3() {
        return this.cognito;
    }

    public final String component4() {
        return this.amplifyAccess;
    }

    public final DebugTokens copy(String poolId, String firebase, String cognito, String amplifyAccess) {
        Intrinsics.checkNotNullParameter(poolId, "poolId");
        Intrinsics.checkNotNullParameter(firebase, "firebase");
        Intrinsics.checkNotNullParameter(cognito, "cognito");
        Intrinsics.checkNotNullParameter(amplifyAccess, "amplifyAccess");
        return new DebugTokens(poolId, firebase, cognito, amplifyAccess);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugTokens)) {
            return false;
        }
        DebugTokens debugTokens = (DebugTokens) obj;
        if (Intrinsics.areEqual(this.poolId, debugTokens.poolId) && Intrinsics.areEqual(this.firebase, debugTokens.firebase) && Intrinsics.areEqual(this.cognito, debugTokens.cognito) && Intrinsics.areEqual(this.amplifyAccess, debugTokens.amplifyAccess)) {
            return true;
        }
        return false;
    }

    public final String getAmplifyAccess() {
        return this.amplifyAccess;
    }

    public final String getCognito() {
        return this.cognito;
    }

    public final String getFirebase() {
        return this.firebase;
    }

    public final String getPoolId() {
        return this.poolId;
    }

    public int hashCode() {
        return this.amplifyAccess.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.cognito, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.firebase, this.poolId.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugTokens(poolId=");
        sb.append(this.poolId);
        sb.append(", firebase=");
        sb.append(this.firebase);
        sb.append(", cognito=");
        sb.append(this.cognito);
        sb.append(", amplifyAccess=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.amplifyAccess, ')');
    }

    public DebugTokens(String poolId, String firebase, String cognito, String amplifyAccess) {
        Intrinsics.checkNotNullParameter(poolId, "poolId");
        Intrinsics.checkNotNullParameter(firebase, "firebase");
        Intrinsics.checkNotNullParameter(cognito, "cognito");
        Intrinsics.checkNotNullParameter(amplifyAccess, "amplifyAccess");
        this.poolId = poolId;
        this.firebase = firebase;
        this.cognito = cognito;
        this.amplifyAccess = amplifyAccess;
    }

    public /* synthetic */ DebugTokens(String str, String str2, String str3, String str4, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? "" : str, (r6 & 2) != 0 ? "" : str2, (r6 & 4) != 0 ? "" : str3, (r6 & 8) != 0 ? "" : str4);
    }
}
