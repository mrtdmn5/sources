package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AnalyticsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugFirmwareStatus {
    public static final int $stable = 0;
    private final String lastDfu;
    private final String updateStatus;
    private final String version;

    public DebugFirmwareStatus() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DebugFirmwareStatus copy$default(DebugFirmwareStatus debugFirmwareStatus, String str, String str2, String str3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = debugFirmwareStatus.version;
        }
        if ((r4 & 2) != 0) {
            str2 = debugFirmwareStatus.updateStatus;
        }
        if ((r4 & 4) != 0) {
            str3 = debugFirmwareStatus.lastDfu;
        }
        return debugFirmwareStatus.copy(str, str2, str3);
    }

    public final String component1() {
        return this.version;
    }

    public final String component2() {
        return this.updateStatus;
    }

    public final String component3() {
        return this.lastDfu;
    }

    public final DebugFirmwareStatus copy(String version, String updateStatus, String lastDfu) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(updateStatus, "updateStatus");
        Intrinsics.checkNotNullParameter(lastDfu, "lastDfu");
        return new DebugFirmwareStatus(version, updateStatus, lastDfu);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugFirmwareStatus)) {
            return false;
        }
        DebugFirmwareStatus debugFirmwareStatus = (DebugFirmwareStatus) obj;
        if (Intrinsics.areEqual(this.version, debugFirmwareStatus.version) && Intrinsics.areEqual(this.updateStatus, debugFirmwareStatus.updateStatus) && Intrinsics.areEqual(this.lastDfu, debugFirmwareStatus.lastDfu)) {
            return true;
        }
        return false;
    }

    public final String getLastDfu() {
        return this.lastDfu;
    }

    public final String getUpdateStatus() {
        return this.updateStatus;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.lastDfu.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.updateStatus, this.version.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugFirmwareStatus(version=");
        sb.append(this.version);
        sb.append(", updateStatus=");
        sb.append(this.updateStatus);
        sb.append(", lastDfu=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.lastDfu, ')');
    }

    public DebugFirmwareStatus(String str, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, AnalyticsConstants.KEY_VERSION, str2, "updateStatus", str3, "lastDfu");
        this.version = str;
        this.updateStatus = str2;
        this.lastDfu = str3;
    }

    public /* synthetic */ DebugFirmwareStatus(String str, String str2, String str3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? "" : str, (r5 & 2) != 0 ? "" : str2, (r5 & 4) != 0 ? "" : str3);
    }
}
