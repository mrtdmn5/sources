package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.Watch;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugUiState {
    public static final int $stable = 0;
    private final DebugAppInfo appStatus;
    private final DebugBleStatus bleStatus;
    private final DebugFirmwareStatus firmwareStatus;
    private final boolean ignoreBatteryOptimization;
    private final String lastDisconnectInfo;
    private final DebugLoadingState loadingStates;
    private final DebugSwitchStatus switches;
    private final DebugTokens tokens;
    private final Watch.WatchState watchState;

    public DebugUiState() {
        this(null, null, null, null, null, null, null, null, false, 511, null);
    }

    public static /* synthetic */ DebugUiState copy$default(DebugUiState debugUiState, DebugBleStatus debugBleStatus, Watch.WatchState watchState, DebugFirmwareStatus debugFirmwareStatus, DebugAppInfo debugAppInfo, DebugSwitchStatus debugSwitchStatus, DebugTokens debugTokens, DebugLoadingState debugLoadingState, String str, boolean z, int r20, Object obj) {
        DebugBleStatus debugBleStatus2;
        Watch.WatchState watchState2;
        DebugFirmwareStatus debugFirmwareStatus2;
        DebugAppInfo debugAppInfo2;
        DebugSwitchStatus debugSwitchStatus2;
        DebugTokens debugTokens2;
        DebugLoadingState debugLoadingState2;
        String str2;
        boolean z2;
        if ((r20 & 1) != 0) {
            debugBleStatus2 = debugUiState.bleStatus;
        } else {
            debugBleStatus2 = debugBleStatus;
        }
        if ((r20 & 2) != 0) {
            watchState2 = debugUiState.watchState;
        } else {
            watchState2 = watchState;
        }
        if ((r20 & 4) != 0) {
            debugFirmwareStatus2 = debugUiState.firmwareStatus;
        } else {
            debugFirmwareStatus2 = debugFirmwareStatus;
        }
        if ((r20 & 8) != 0) {
            debugAppInfo2 = debugUiState.appStatus;
        } else {
            debugAppInfo2 = debugAppInfo;
        }
        if ((r20 & 16) != 0) {
            debugSwitchStatus2 = debugUiState.switches;
        } else {
            debugSwitchStatus2 = debugSwitchStatus;
        }
        if ((r20 & 32) != 0) {
            debugTokens2 = debugUiState.tokens;
        } else {
            debugTokens2 = debugTokens;
        }
        if ((r20 & 64) != 0) {
            debugLoadingState2 = debugUiState.loadingStates;
        } else {
            debugLoadingState2 = debugLoadingState;
        }
        if ((r20 & 128) != 0) {
            str2 = debugUiState.lastDisconnectInfo;
        } else {
            str2 = str;
        }
        if ((r20 & 256) != 0) {
            z2 = debugUiState.ignoreBatteryOptimization;
        } else {
            z2 = z;
        }
        return debugUiState.copy(debugBleStatus2, watchState2, debugFirmwareStatus2, debugAppInfo2, debugSwitchStatus2, debugTokens2, debugLoadingState2, str2, z2);
    }

    public final DebugBleStatus component1() {
        return this.bleStatus;
    }

    public final Watch.WatchState component2() {
        return this.watchState;
    }

    public final DebugFirmwareStatus component3() {
        return this.firmwareStatus;
    }

    public final DebugAppInfo component4() {
        return this.appStatus;
    }

    public final DebugSwitchStatus component5() {
        return this.switches;
    }

    public final DebugTokens component6() {
        return this.tokens;
    }

    public final DebugLoadingState component7() {
        return this.loadingStates;
    }

    public final String component8() {
        return this.lastDisconnectInfo;
    }

    public final boolean component9() {
        return this.ignoreBatteryOptimization;
    }

    public final DebugUiState copy(DebugBleStatus bleStatus, Watch.WatchState watchState, DebugFirmwareStatus firmwareStatus, DebugAppInfo appStatus, DebugSwitchStatus switches, DebugTokens tokens, DebugLoadingState loadingStates, String lastDisconnectInfo, boolean z) {
        Intrinsics.checkNotNullParameter(bleStatus, "bleStatus");
        Intrinsics.checkNotNullParameter(watchState, "watchState");
        Intrinsics.checkNotNullParameter(firmwareStatus, "firmwareStatus");
        Intrinsics.checkNotNullParameter(appStatus, "appStatus");
        Intrinsics.checkNotNullParameter(switches, "switches");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Intrinsics.checkNotNullParameter(loadingStates, "loadingStates");
        Intrinsics.checkNotNullParameter(lastDisconnectInfo, "lastDisconnectInfo");
        return new DebugUiState(bleStatus, watchState, firmwareStatus, appStatus, switches, tokens, loadingStates, lastDisconnectInfo, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugUiState)) {
            return false;
        }
        DebugUiState debugUiState = (DebugUiState) obj;
        if (Intrinsics.areEqual(this.bleStatus, debugUiState.bleStatus) && this.watchState == debugUiState.watchState && Intrinsics.areEqual(this.firmwareStatus, debugUiState.firmwareStatus) && Intrinsics.areEqual(this.appStatus, debugUiState.appStatus) && Intrinsics.areEqual(this.switches, debugUiState.switches) && Intrinsics.areEqual(this.tokens, debugUiState.tokens) && Intrinsics.areEqual(this.loadingStates, debugUiState.loadingStates) && Intrinsics.areEqual(this.lastDisconnectInfo, debugUiState.lastDisconnectInfo) && this.ignoreBatteryOptimization == debugUiState.ignoreBatteryOptimization) {
            return true;
        }
        return false;
    }

    public final DebugAppInfo getAppStatus() {
        return this.appStatus;
    }

    public final DebugBleStatus getBleStatus() {
        return this.bleStatus;
    }

    public final DebugFirmwareStatus getFirmwareStatus() {
        return this.firmwareStatus;
    }

    public final boolean getIgnoreBatteryOptimization() {
        return this.ignoreBatteryOptimization;
    }

    public final String getLastDisconnectInfo() {
        return this.lastDisconnectInfo;
    }

    public final DebugLoadingState getLoadingStates() {
        return this.loadingStates;
    }

    public final DebugSwitchStatus getSwitches() {
        return this.switches;
    }

    public final DebugTokens getTokens() {
        return this.tokens;
    }

    public final Watch.WatchState getWatchState() {
        return this.watchState;
    }

    public int hashCode() {
        return Boolean.hashCode(this.ignoreBatteryOptimization) + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.lastDisconnectInfo, (this.loadingStates.hashCode() + ((this.tokens.hashCode() + ((this.switches.hashCode() + ((this.appStatus.hashCode() + ((this.firmwareStatus.hashCode() + ((this.watchState.hashCode() + (this.bleStatus.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugUiState(bleStatus=");
        sb.append(this.bleStatus);
        sb.append(", watchState=");
        sb.append(this.watchState);
        sb.append(", firmwareStatus=");
        sb.append(this.firmwareStatus);
        sb.append(", appStatus=");
        sb.append(this.appStatus);
        sb.append(", switches=");
        sb.append(this.switches);
        sb.append(", tokens=");
        sb.append(this.tokens);
        sb.append(", loadingStates=");
        sb.append(this.loadingStates);
        sb.append(", lastDisconnectInfo=");
        sb.append(this.lastDisconnectInfo);
        sb.append(", ignoreBatteryOptimization=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.ignoreBatteryOptimization, ')');
    }

    public DebugUiState(DebugBleStatus bleStatus, Watch.WatchState watchState, DebugFirmwareStatus firmwareStatus, DebugAppInfo appStatus, DebugSwitchStatus switches, DebugTokens tokens, DebugLoadingState loadingStates, String lastDisconnectInfo, boolean z) {
        Intrinsics.checkNotNullParameter(bleStatus, "bleStatus");
        Intrinsics.checkNotNullParameter(watchState, "watchState");
        Intrinsics.checkNotNullParameter(firmwareStatus, "firmwareStatus");
        Intrinsics.checkNotNullParameter(appStatus, "appStatus");
        Intrinsics.checkNotNullParameter(switches, "switches");
        Intrinsics.checkNotNullParameter(tokens, "tokens");
        Intrinsics.checkNotNullParameter(loadingStates, "loadingStates");
        Intrinsics.checkNotNullParameter(lastDisconnectInfo, "lastDisconnectInfo");
        this.bleStatus = bleStatus;
        this.watchState = watchState;
        this.firmwareStatus = firmwareStatus;
        this.appStatus = appStatus;
        this.switches = switches;
        this.tokens = tokens;
        this.loadingStates = loadingStates;
        this.lastDisconnectInfo = lastDisconnectInfo;
        this.ignoreBatteryOptimization = z;
    }

    public /* synthetic */ DebugUiState(DebugBleStatus debugBleStatus, Watch.WatchState watchState, DebugFirmwareStatus debugFirmwareStatus, DebugAppInfo debugAppInfo, DebugSwitchStatus debugSwitchStatus, DebugTokens debugTokens, DebugLoadingState debugLoadingState, String str, boolean z, int r30, DefaultConstructorMarker defaultConstructorMarker) {
        this((r30 & 1) != 0 ? new DebugBleStatus(null, false, 3, null) : debugBleStatus, (r30 & 2) != 0 ? Watch.WatchState.Disconnected : watchState, (r30 & 4) != 0 ? new DebugFirmwareStatus(null, null, null, 7, null) : debugFirmwareStatus, (r30 & 8) != 0 ? new DebugAppInfo(null, null, false, false, 15, null) : debugAppInfo, (r30 & 16) != 0 ? new DebugSwitchStatus(false, false, false, false, false, false, false, false, false, false, 1023, null) : debugSwitchStatus, (r30 & 32) != 0 ? new DebugTokens(null, null, null, null, 15, null) : debugTokens, (r30 & 64) != 0 ? new DebugLoadingState(false, false, false, 7, null) : debugLoadingState, (r30 & 128) != 0 ? "" : str, (r30 & 256) == 0 ? z : false);
    }
}
