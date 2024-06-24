package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {
    public final Double batteryLevel;
    public final int batteryVelocity;
    public final long diskUsed;
    public final int orientation;
    public final boolean proximityOn;
    public final long ramUsed;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {
        public Double batteryLevel;
        public Integer batteryVelocity;
        public Long diskUsed;
        public Integer orientation;
        public Boolean proximityOn;
        public Long ramUsed;

        public final AutoValue_CrashlyticsReport_Session_Event_Device build() {
            String str;
            if (this.batteryVelocity == null) {
                str = " batteryVelocity";
            } else {
                str = "";
            }
            if (this.proximityOn == null) {
                str = str.concat(" proximityOn");
            }
            if (this.orientation == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " orientation");
            }
            if (this.ramUsed == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " ramUsed");
            }
            if (this.diskUsed == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " diskUsed");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.batteryLevel, this.batteryVelocity.intValue(), this.proximityOn.booleanValue(), this.orientation.intValue(), this.ramUsed.longValue(), this.diskUsed.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Device(Double d, int r2, boolean z, int r4, long j, long j2) {
        this.batteryLevel = d;
        this.batteryVelocity = r2;
        this.proximityOn = z;
        this.orientation = r4;
        this.ramUsed = j;
        this.diskUsed = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d = this.batteryLevel;
        if (d != null ? d.equals(device.getBatteryLevel()) : device.getBatteryLevel() == null) {
            if (this.batteryVelocity == device.getBatteryVelocity() && this.proximityOn == device.isProximityOn() && this.orientation == device.getOrientation() && this.ramUsed == device.getRamUsed() && this.diskUsed == device.getDiskUsed()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final Double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final long getDiskUsed() {
        return this.diskUsed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final int getOrientation() {
        return this.orientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final long getRamUsed() {
        return this.ramUsed;
    }

    public final int hashCode() {
        int hashCode;
        int r2;
        Double d = this.batteryLevel;
        if (d == null) {
            hashCode = 0;
        } else {
            hashCode = d.hashCode();
        }
        int r0 = (((hashCode ^ 1000003) * 1000003) ^ this.batteryVelocity) * 1000003;
        if (this.proximityOn) {
            r2 = 1231;
        } else {
            r2 = 1237;
        }
        int r02 = (((r0 ^ r2) * 1000003) ^ this.orientation) * 1000003;
        long j = this.ramUsed;
        long j2 = this.diskUsed;
        return ((r02 ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device
    public final boolean isProximityOn() {
        return this.proximityOn;
    }

    public final String toString() {
        return "Device{batteryLevel=" + this.batteryLevel + ", batteryVelocity=" + this.batteryVelocity + ", proximityOn=" + this.proximityOn + ", orientation=" + this.orientation + ", ramUsed=" + this.ramUsed + ", diskUsed=" + this.diskUsed + "}";
    }
}
