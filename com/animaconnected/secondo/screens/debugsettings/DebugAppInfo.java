package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugAppInfo {
    public static final int $stable = 0;
    private final String category;
    private final boolean isLoggerDogfood;
    private final boolean isSandbox;
    private final String version;

    public DebugAppInfo() {
        this(null, null, false, false, 15, null);
    }

    public static /* synthetic */ DebugAppInfo copy$default(DebugAppInfo debugAppInfo, String str, String str2, boolean z, boolean z2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = debugAppInfo.version;
        }
        if ((r5 & 2) != 0) {
            str2 = debugAppInfo.category;
        }
        if ((r5 & 4) != 0) {
            z = debugAppInfo.isSandbox;
        }
        if ((r5 & 8) != 0) {
            z2 = debugAppInfo.isLoggerDogfood;
        }
        return debugAppInfo.copy(str, str2, z, z2);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.category;
    }

    public final boolean component3() {
        return this.isSandbox;
    }

    public final boolean component4() {
        return this.isLoggerDogfood;
    }

    public final DebugAppInfo copy(String version, String category, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(category, "category");
        return new DebugAppInfo(version, category, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugAppInfo)) {
            return false;
        }
        DebugAppInfo debugAppInfo = (DebugAppInfo) obj;
        if (Intrinsics.areEqual(this.version, debugAppInfo.version) && Intrinsics.areEqual(this.category, debugAppInfo.category) && this.isSandbox == debugAppInfo.isSandbox && this.isLoggerDogfood == debugAppInfo.isLoggerDogfood) {
            return true;
        }
        return false;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLoggerDogfood) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isSandbox, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.category, this.version.hashCode() * 31, 31), 31);
    }

    public final boolean isLoggerDogfood() {
        return this.isLoggerDogfood;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugAppInfo(version=");
        sb.append(this.version);
        sb.append(", category=");
        sb.append(this.category);
        sb.append(", isSandbox=");
        sb.append(this.isSandbox);
        sb.append(", isLoggerDogfood=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isLoggerDogfood, ')');
    }

    public DebugAppInfo(String version, String category, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(category, "category");
        this.version = version;
        this.category = category;
        this.isSandbox = z;
        this.isLoggerDogfood = z2;
    }

    public /* synthetic */ DebugAppInfo(String str, String str2, boolean z, boolean z2, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? "" : str, (r6 & 2) != 0 ? "" : str2, (r6 & 4) != 0 ? false : z, (r6 & 8) != 0 ? false : z2);
    }
}
