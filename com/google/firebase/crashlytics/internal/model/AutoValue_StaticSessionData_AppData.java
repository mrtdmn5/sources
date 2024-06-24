package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {
    public final String appIdentifier;
    public final int deliveryMechanism;
    public final DevelopmentPlatformProvider developmentPlatformProvider;
    public final String installUuid;
    public final String versionCode;
    public final String versionName;

    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int r5, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str != null) {
            this.appIdentifier = str;
            if (str2 != null) {
                this.versionCode = str2;
                if (str3 != null) {
                    this.versionName = str3;
                    if (str4 != null) {
                        this.installUuid = str4;
                        this.deliveryMechanism = r5;
                        if (developmentPlatformProvider != null) {
                            this.developmentPlatformProvider = developmentPlatformProvider;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String appIdentifier() {
        return this.appIdentifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final int deliveryMechanism() {
        return this.deliveryMechanism;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final DevelopmentPlatformProvider developmentPlatformProvider() {
        return this.developmentPlatformProvider;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        if (this.appIdentifier.equals(appData.appIdentifier()) && this.versionCode.equals(appData.versionCode()) && this.versionName.equals(appData.versionName()) && this.installUuid.equals(appData.installUuid()) && this.deliveryMechanism == appData.deliveryMechanism() && this.developmentPlatformProvider.equals(appData.developmentPlatformProvider())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((this.appIdentifier.hashCode() ^ 1000003) * 1000003) ^ this.versionCode.hashCode()) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.installUuid.hashCode()) * 1000003) ^ this.deliveryMechanism) * 1000003) ^ this.developmentPlatformProvider.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String installUuid() {
        return this.installUuid;
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.appIdentifier + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", installUuid=" + this.installUuid + ", deliveryMechanism=" + this.deliveryMechanism + ", developmentPlatformProvider=" + this.developmentPlatformProvider + "}";
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String versionCode() {
        return this.versionCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData
    public final String versionName() {
        return this.versionName;
    }
}
