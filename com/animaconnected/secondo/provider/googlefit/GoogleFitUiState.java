package com.animaconnected.secondo.provider.googlefit;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: GoogleFitProvider.kt */
/* loaded from: classes3.dex */
public final class GoogleFitUiState {
    public static final int $stable = 0;
    private final boolean isConnected;
    private final boolean scopesEnabled;
    private final boolean showBadge;

    public GoogleFitUiState() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ GoogleFitUiState copy$default(GoogleFitUiState googleFitUiState, boolean z, boolean z2, boolean z3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = googleFitUiState.isConnected;
        }
        if ((r4 & 2) != 0) {
            z2 = googleFitUiState.scopesEnabled;
        }
        if ((r4 & 4) != 0) {
            z3 = googleFitUiState.showBadge;
        }
        return googleFitUiState.copy(z, z2, z3);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.scopesEnabled;
    }

    public final boolean component3() {
        return this.showBadge;
    }

    public final GoogleFitUiState copy(boolean z, boolean z2, boolean z3) {
        return new GoogleFitUiState(z, z2, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleFitUiState)) {
            return false;
        }
        GoogleFitUiState googleFitUiState = (GoogleFitUiState) obj;
        if (this.isConnected == googleFitUiState.isConnected && this.scopesEnabled == googleFitUiState.scopesEnabled && this.showBadge == googleFitUiState.showBadge) {
            return true;
        }
        return false;
    }

    public final boolean getRequiresAttention() {
        if (this.isConnected && this.scopesEnabled) {
            return false;
        }
        return true;
    }

    public final boolean getScopesEnabled() {
        return this.scopesEnabled;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public int hashCode() {
        return Boolean.hashCode(this.showBadge) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.scopesEnabled, Boolean.hashCode(this.isConnected) * 31, 31);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GoogleFitUiState(isConnected=");
        sb.append(this.isConnected);
        sb.append(", scopesEnabled=");
        sb.append(this.scopesEnabled);
        sb.append(", showBadge=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.showBadge, ')');
    }

    public GoogleFitUiState(boolean z, boolean z2, boolean z3) {
        this.isConnected = z;
        this.scopesEnabled = z2;
        this.showBadge = z3;
    }

    public /* synthetic */ GoogleFitUiState(boolean z, boolean z2, boolean z3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? false : z, (r5 & 2) != 0 ? false : z2, (r5 & 4) != 0 ? false : z3);
    }
}
