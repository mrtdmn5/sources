package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {
    public final int arch;
    public final int cores;
    public final long diskSpace;
    public final String manufacturer;
    public final String model;
    public final String modelClass;
    public final long ram;
    public final boolean simulator;
    public final int state;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Device.Builder {
        public Integer arch;
        public Integer cores;
        public Long diskSpace;
        public String manufacturer;
        public String model;
        public String modelClass;
        public Long ram;
        public Boolean simulator;
        public Integer state;

        public final AutoValue_CrashlyticsReport_Session_Device build() {
            String str;
            if (this.arch == null) {
                str = " arch";
            } else {
                str = "";
            }
            if (this.model == null) {
                str = str.concat(" model");
            }
            if (this.cores == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " cores");
            }
            if (this.ram == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " ram");
            }
            if (this.diskSpace == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " diskSpace");
            }
            if (this.simulator == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " simulator");
            }
            if (this.state == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " state");
            }
            if (this.manufacturer == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " manufacturer");
            }
            if (this.modelClass == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " modelClass");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Device(int r1, String str, int r3, long j, long j2, boolean z, int r9, String str2, String str3) {
        this.arch = r1;
        this.model = str;
        this.cores = r3;
        this.ram = j;
        this.diskSpace = j2;
        this.simulator = z;
        this.state = r9;
        this.manufacturer = str2;
        this.modelClass = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        if (this.arch == device.getArch() && this.model.equals(device.getModel()) && this.cores == device.getCores() && this.ram == device.getRam() && this.diskSpace == device.getDiskSpace() && this.simulator == device.isSimulator() && this.state == device.getState() && this.manufacturer.equals(device.getManufacturer()) && this.modelClass.equals(device.getModelClass())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int getArch() {
        return this.arch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int getCores() {
        return this.cores;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final long getDiskSpace() {
        return this.diskSpace;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String getManufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String getModel() {
        return this.model;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final String getModelClass() {
        return this.modelClass;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final long getRam() {
        return this.ram;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final int getState() {
        return this.state;
    }

    public final int hashCode() {
        int r2;
        int hashCode = (((((this.arch ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cores) * 1000003;
        long j = this.ram;
        int r0 = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.diskSpace;
        int r02 = (r0 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        if (this.simulator) {
            r2 = 1231;
        } else {
            r2 = 1237;
        }
        return ((((((r02 ^ r2) * 1000003) ^ this.state) * 1000003) ^ this.manufacturer.hashCode()) * 1000003) ^ this.modelClass.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device
    public final boolean isSimulator() {
        return this.simulator;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Device{arch=");
        sb.append(this.arch);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", cores=");
        sb.append(this.cores);
        sb.append(", ram=");
        sb.append(this.ram);
        sb.append(", diskSpace=");
        sb.append(this.diskSpace);
        sb.append(", simulator=");
        sb.append(this.simulator);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", modelClass=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.modelClass, "}");
    }
}
