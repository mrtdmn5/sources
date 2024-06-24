package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    public final String buildVersion;
    public final String displayVersion;
    public final String gmpAppId;
    public final String installationUuid;
    public final CrashlyticsReport.FilesPayload ndkPayload;
    public final int platform;
    public final String sdkVersion;
    public final CrashlyticsReport.Session session;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Builder {
        public String buildVersion;
        public String displayVersion;
        public String gmpAppId;
        public String installationUuid;
        public CrashlyticsReport.FilesPayload ndkPayload;
        public Integer platform;
        public String sdkVersion;
        public CrashlyticsReport.Session session;

        public Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
        }

        public final AutoValue_CrashlyticsReport build() {
            String str;
            if (this.sdkVersion == null) {
                str = " sdkVersion";
            } else {
                str = "";
            }
            if (this.gmpAppId == null) {
                str = str.concat(" gmpAppId");
            }
            if (this.platform == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " platform");
            }
            if (this.installationUuid == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " installationUuid");
            }
            if (this.buildVersion == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " buildVersion");
            }
            if (this.displayVersion == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " displayVersion");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport(String str, String str2, int r3, String str3, String str4, String str5, CrashlyticsReport.Session session, CrashlyticsReport.FilesPayload filesPayload) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = r3;
        this.installationUuid = str3;
        this.buildVersion = str4;
        this.displayVersion = str5;
        this.session = session;
        this.ndkPayload = filesPayload;
    }

    public final boolean equals(Object obj) {
        CrashlyticsReport.Session session;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.sdkVersion.equals(crashlyticsReport.getSdkVersion()) && this.gmpAppId.equals(crashlyticsReport.getGmpAppId()) && this.platform == crashlyticsReport.getPlatform() && this.installationUuid.equals(crashlyticsReport.getInstallationUuid()) && this.buildVersion.equals(crashlyticsReport.getBuildVersion()) && this.displayVersion.equals(crashlyticsReport.getDisplayVersion()) && ((session = this.session) != null ? session.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null)) {
            CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
            if (filesPayload == null) {
                if (crashlyticsReport.getNdkPayload() == null) {
                    return true;
                }
            } else if (filesPayload.equals(crashlyticsReport.getNdkPayload())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getDisplayVersion() {
        return this.displayVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getGmpAppId() {
        return this.gmpAppId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getInstallationUuid() {
        return this.installationUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public final CrashlyticsReport.Session getSession() {
        return this.session;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((this.sdkVersion.hashCode() ^ 1000003) * 1000003) ^ this.gmpAppId.hashCode()) * 1000003) ^ this.platform) * 1000003) ^ this.installationUuid.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ this.displayVersion.hashCode()) * 1000003;
        int r2 = 0;
        CrashlyticsReport.Session session = this.session;
        if (session == null) {
            hashCode = 0;
        } else {
            hashCode = session.hashCode();
        }
        int r0 = (hashCode2 ^ hashCode) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.ndkPayload;
        if (filesPayload != null) {
            r2 = filesPayload.hashCode();
        }
        return r0 ^ r2;
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.sdkVersion + ", gmpAppId=" + this.gmpAppId + ", platform=" + this.platform + ", installationUuid=" + this.installationUuid + ", buildVersion=" + this.buildVersion + ", displayVersion=" + this.displayVersion + ", session=" + this.session + ", ndkPayload=" + this.ndkPayload + "}";
    }
}
