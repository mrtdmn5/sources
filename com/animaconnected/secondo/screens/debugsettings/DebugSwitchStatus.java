package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: DebugUiState.kt */
/* loaded from: classes3.dex */
public final class DebugSwitchStatus {
    public static final int $stable = 0;
    private final boolean appAlwaysOn;
    private final boolean bluetoothDebug;
    private final boolean customerSupportDev;
    private final boolean demoMode;
    private final boolean healthDashboard;
    private final boolean ktorLogs;
    private final boolean mockFitness;
    private final boolean rssiLiveUpdates;
    private final boolean speedCalibration;
    private final boolean workInProgress;

    public DebugSwitchStatus() {
        this(false, false, false, false, false, false, false, false, false, false, 1023, null);
    }

    public final boolean component1() {
        return this.demoMode;
    }

    public final boolean component10() {
        return this.rssiLiveUpdates;
    }

    public final boolean component2() {
        return this.mockFitness;
    }

    public final boolean component3() {
        return this.speedCalibration;
    }

    public final boolean component4() {
        return this.workInProgress;
    }

    public final boolean component5() {
        return this.healthDashboard;
    }

    public final boolean component6() {
        return this.ktorLogs;
    }

    public final boolean component7() {
        return this.appAlwaysOn;
    }

    public final boolean component8() {
        return this.customerSupportDev;
    }

    public final boolean component9() {
        return this.bluetoothDebug;
    }

    public final DebugSwitchStatus copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        return new DebugSwitchStatus(z, z2, z3, z4, z5, z6, z7, z8, z9, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DebugSwitchStatus)) {
            return false;
        }
        DebugSwitchStatus debugSwitchStatus = (DebugSwitchStatus) obj;
        if (this.demoMode == debugSwitchStatus.demoMode && this.mockFitness == debugSwitchStatus.mockFitness && this.speedCalibration == debugSwitchStatus.speedCalibration && this.workInProgress == debugSwitchStatus.workInProgress && this.healthDashboard == debugSwitchStatus.healthDashboard && this.ktorLogs == debugSwitchStatus.ktorLogs && this.appAlwaysOn == debugSwitchStatus.appAlwaysOn && this.customerSupportDev == debugSwitchStatus.customerSupportDev && this.bluetoothDebug == debugSwitchStatus.bluetoothDebug && this.rssiLiveUpdates == debugSwitchStatus.rssiLiveUpdates) {
            return true;
        }
        return false;
    }

    public final boolean getAppAlwaysOn() {
        return this.appAlwaysOn;
    }

    public final boolean getBluetoothDebug() {
        return this.bluetoothDebug;
    }

    public final boolean getCustomerSupportDev() {
        return this.customerSupportDev;
    }

    public final boolean getDemoMode() {
        return this.demoMode;
    }

    public final boolean getHealthDashboard() {
        return this.healthDashboard;
    }

    public final boolean getKtorLogs() {
        return this.ktorLogs;
    }

    public final boolean getMockFitness() {
        return this.mockFitness;
    }

    public final boolean getRssiLiveUpdates() {
        return this.rssiLiveUpdates;
    }

    public final boolean getSpeedCalibration() {
        return this.speedCalibration;
    }

    public final boolean getWorkInProgress() {
        return this.workInProgress;
    }

    public int hashCode() {
        return Boolean.hashCode(this.rssiLiveUpdates) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.bluetoothDebug, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.customerSupportDev, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.appAlwaysOn, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.ktorLogs, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.healthDashboard, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.workInProgress, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.speedCalibration, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.mockFitness, Boolean.hashCode(this.demoMode) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DebugSwitchStatus(demoMode=");
        sb.append(this.demoMode);
        sb.append(", mockFitness=");
        sb.append(this.mockFitness);
        sb.append(", speedCalibration=");
        sb.append(this.speedCalibration);
        sb.append(", workInProgress=");
        sb.append(this.workInProgress);
        sb.append(", healthDashboard=");
        sb.append(this.healthDashboard);
        sb.append(", ktorLogs=");
        sb.append(this.ktorLogs);
        sb.append(", appAlwaysOn=");
        sb.append(this.appAlwaysOn);
        sb.append(", customerSupportDev=");
        sb.append(this.customerSupportDev);
        sb.append(", bluetoothDebug=");
        sb.append(this.bluetoothDebug);
        sb.append(", rssiLiveUpdates=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.rssiLiveUpdates, ')');
    }

    public DebugSwitchStatus(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.demoMode = z;
        this.mockFitness = z2;
        this.speedCalibration = z3;
        this.workInProgress = z4;
        this.healthDashboard = z5;
        this.ktorLogs = z6;
        this.appAlwaysOn = z7;
        this.customerSupportDev = z8;
        this.bluetoothDebug = z9;
        this.rssiLiveUpdates = z10;
    }

    public /* synthetic */ DebugSwitchStatus(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int r22, DefaultConstructorMarker defaultConstructorMarker) {
        this((r22 & 1) != 0 ? false : z, (r22 & 2) != 0 ? false : z2, (r22 & 4) != 0 ? false : z3, (r22 & 8) != 0 ? false : z4, (r22 & 16) != 0 ? false : z5, (r22 & 32) != 0 ? false : z6, (r22 & 64) != 0 ? false : z7, (r22 & 128) != 0 ? false : z8, (r22 & 256) != 0 ? false : z9, (r22 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) == 0 ? z10 : false);
    }
}
