package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {
    public final int arch;
    public final int availableProcessors;
    public final long diskSpace;
    public final boolean isEmulator;
    public final String manufacturer;
    public final String model;
    public final String modelClass;
    public final int state;
    public final long totalRam;

    public AutoValue_StaticSessionData_DeviceData(int r1, String str, int r3, long j, long j2, boolean z, int r9, String str2, String str3) {
        this.arch = r1;
        if (str != null) {
            this.model = str;
            this.availableProcessors = r3;
            this.totalRam = j;
            this.diskSpace = j2;
            this.isEmulator = z;
            this.state = r9;
            if (str2 != null) {
                this.manufacturer = str2;
                if (str3 != null) {
                    this.modelClass = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int arch() {
        return this.arch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int availableProcessors() {
        return this.availableProcessors;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long diskSpace() {
        return this.diskSpace;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        if (this.arch == deviceData.arch() && this.model.equals(deviceData.model()) && this.availableProcessors == deviceData.availableProcessors() && this.totalRam == deviceData.totalRam() && this.diskSpace == deviceData.diskSpace() && this.isEmulator == deviceData.isEmulator() && this.state == deviceData.state() && this.manufacturer.equals(deviceData.manufacturer()) && this.modelClass.equals(deviceData.modelClass())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r2;
        int hashCode = (((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.availableProcessors) * 1000003;
        long j = this.totalRam;
        int r0 = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.diskSpace;
        int r02 = (r0 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (this.isEmulator) {
            r2 = 1231;
        } else {
            r2 = 1237;
        }
        return ((((((r02 ^ r2) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final boolean isEmulator() {
        return this.isEmulator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String manufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String model() {
        return this.model;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final String modelClass() {
        return this.modelClass;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final int state() {
        return this.state;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.arch);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", availableProcessors=");
        sb.append(this.availableProcessors);
        sb.append(", totalRam=");
        sb.append(this.totalRam);
        sb.append(", diskSpace=");
        sb.append(this.diskSpace);
        sb.append(", isEmulator=");
        sb.append(this.isEmulator);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", modelClass=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.modelClass, "}");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData
    public final long totalRam() {
        return this.totalRam;
    }
}
