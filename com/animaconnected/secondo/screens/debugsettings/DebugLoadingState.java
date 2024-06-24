package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugLoadingState {
    public static final int $stable = 0;
    private final boolean isDeviceScanning;
    private final boolean isFakeConnecting;
    private final boolean isReadingPostMortem;

    public DebugLoadingState() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ DebugLoadingState copy$default(DebugLoadingState debugLoadingState, boolean z, boolean z2, boolean z3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = debugLoadingState.isReadingPostMortem;
        }
        if ((r4 & 2) != 0) {
            z2 = debugLoadingState.isFakeConnecting;
        }
        if ((r4 & 4) != 0) {
            z3 = debugLoadingState.isDeviceScanning;
        }
        return debugLoadingState.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.isReadingPostMortem;
    }

    public final boolean component2() {
        return this.isFakeConnecting;
    }

    public final boolean component3() {
        return this.isDeviceScanning;
    }

    public final DebugLoadingState copy(boolean z, boolean z2, boolean z3) {
        return new DebugLoadingState(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugLoadingState)) {
            return false;
        }
        DebugLoadingState debugLoadingState = (DebugLoadingState) obj;
        if (this.isReadingPostMortem == debugLoadingState.isReadingPostMortem && this.isFakeConnecting == debugLoadingState.isFakeConnecting && this.isDeviceScanning == debugLoadingState.isDeviceScanning) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isDeviceScanning) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isFakeConnecting, Boolean.hashCode(this.isReadingPostMortem) * 31, 31);
    }

    public final boolean isDeviceScanning() {
        return this.isDeviceScanning;
    }

    public final boolean isFakeConnecting() {
        return this.isFakeConnecting;
    }

    public final boolean isReadingPostMortem() {
        return this.isReadingPostMortem;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugLoadingState(isReadingPostMortem=");
        sb.append(this.isReadingPostMortem);
        sb.append(", isFakeConnecting=");
        sb.append(this.isFakeConnecting);
        sb.append(", isDeviceScanning=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isDeviceScanning, ')');
    }

    public DebugLoadingState(boolean z, boolean z2, boolean z3) {
        this.isReadingPostMortem = z;
        this.isFakeConnecting = z2;
        this.isDeviceScanning = z3;
    }

    public /* synthetic */ DebugLoadingState(boolean z, boolean z2, boolean z3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? false : z, (r5 & 2) != 0 ? false : z2, (r5 & 4) != 0 ? false : z3);
    }
}
