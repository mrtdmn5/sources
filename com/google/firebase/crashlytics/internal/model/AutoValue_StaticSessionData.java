package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData extends StaticSessionData {
    public final StaticSessionData.AppData appData;
    public final StaticSessionData.DeviceData deviceData;
    public final StaticSessionData.OsData osData;

    public AutoValue_StaticSessionData(AutoValue_StaticSessionData_AppData autoValue_StaticSessionData_AppData, AutoValue_StaticSessionData_OsData autoValue_StaticSessionData_OsData, AutoValue_StaticSessionData_DeviceData autoValue_StaticSessionData_DeviceData) {
        this.appData = autoValue_StaticSessionData_AppData;
        this.osData = autoValue_StaticSessionData_OsData;
        this.deviceData = autoValue_StaticSessionData_DeviceData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.AppData appData() {
        return this.appData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.DeviceData deviceData() {
        return this.deviceData;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        if (this.appData.equals(staticSessionData.appData()) && this.osData.equals(staticSessionData.osData()) && this.deviceData.equals(staticSessionData.deviceData())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.appData.hashCode() ^ 1000003) * 1000003) ^ this.osData.hashCode()) * 1000003) ^ this.deviceData.hashCode();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public final StaticSessionData.OsData osData() {
        return this.osData;
    }

    public final String toString() {
        return "StaticSessionData{appData=" + this.appData + ", osData=" + this.osData + ", deviceData=" + this.deviceData + "}";
    }
}
