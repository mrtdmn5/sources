package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {
    public final String buildVersion;
    public final boolean jailbroken;
    public final int platform;
    public final String version;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {
        public String buildVersion;
        public Boolean jailbroken;
        public Integer platform;
        public String version;

        public final AutoValue_CrashlyticsReport_Session_OperatingSystem build() {
            String str;
            if (this.platform == null) {
                str = " platform";
            } else {
                str = "";
            }
            if (this.version == null) {
                str = str.concat(" version");
            }
            if (this.buildVersion == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " buildVersion");
            }
            if (this.jailbroken == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " jailbroken");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_OperatingSystem(int r1, String str, String str2, boolean z) {
        this.platform = r1;
        this.version = str;
        this.buildVersion = str2;
        this.jailbroken = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        if (this.platform == operatingSystem.getPlatform() && this.version.equals(operatingSystem.getVersion()) && this.buildVersion.equals(operatingSystem.getBuildVersion()) && this.jailbroken == operatingSystem.isJailbroken()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final String getVersion() {
        return this.version;
    }

    public final int hashCode() {
        int r1;
        int hashCode = (((((this.platform ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003;
        if (this.jailbroken) {
            r1 = 1231;
        } else {
            r1 = 1237;
        }
        return hashCode ^ r1;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem
    public final boolean isJailbroken() {
        return this.jailbroken;
    }

    public final String toString() {
        return "OperatingSystem{platform=" + this.platform + ", version=" + this.version + ", buildVersion=" + this.buildVersion + ", jailbroken=" + this.jailbroken + "}";
    }
}
