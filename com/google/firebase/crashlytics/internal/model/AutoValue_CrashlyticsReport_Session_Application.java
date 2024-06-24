package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {
    public final String developmentPlatform;
    public final String developmentPlatformVersion;
    public final String displayVersion;
    public final String identifier;
    public final String installationUuid;
    public final CrashlyticsReport.Session.Application.Organization organization = null;
    public final String version;

    public AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, String str4, String str5, String str6) {
        this.identifier = str;
        this.version = str2;
        this.displayVersion = str3;
        this.installationUuid = str4;
        this.developmentPlatform = str5;
        this.developmentPlatformVersion = str6;
    }

    public final boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.identifier.equals(application.getIdentifier()) && this.version.equals(application.getVersion()) && ((str = this.displayVersion) != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) && ((organization = this.organization) != null ? organization.equals(application.getOrganization()) : application.getOrganization() == null) && ((str2 = this.installationUuid) != null ? str2.equals(application.getInstallationUuid()) : application.getInstallationUuid() == null) && ((str3 = this.developmentPlatform) != null ? str3.equals(application.getDevelopmentPlatform()) : application.getDevelopmentPlatform() == null)) {
            String str4 = this.developmentPlatformVersion;
            if (str4 == null) {
                if (application.getDevelopmentPlatformVersion() == null) {
                    return true;
                }
            } else if (str4.equals(application.getDevelopmentPlatformVersion())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getDisplayVersion() {
        return this.displayVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getInstallationUuid() {
        return this.installationUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.organization;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application
    public final String getVersion() {
        return this.version;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = (((this.identifier.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003;
        int r2 = 0;
        String str = this.displayVersion;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (hashCode5 ^ hashCode) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.organization;
        if (organization == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = organization.hashCode();
        }
        int r02 = (r0 ^ hashCode2) * 1000003;
        String str2 = this.installationUuid;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int r03 = (r02 ^ hashCode3) * 1000003;
        String str3 = this.developmentPlatform;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int r04 = (r03 ^ hashCode4) * 1000003;
        String str4 = this.developmentPlatformVersion;
        if (str4 != null) {
            r2 = str4.hashCode();
        }
        return r04 ^ r2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.identifier);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", displayVersion=");
        sb.append(this.displayVersion);
        sb.append(", organization=");
        sb.append(this.organization);
        sb.append(", installationUuid=");
        sb.append(this.installationUuid);
        sb.append(", developmentPlatform=");
        sb.append(this.developmentPlatform);
        sb.append(", developmentPlatformVersion=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.developmentPlatformVersion, "}");
    }
}
