package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes3.dex */
public final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {
    public final boolean isRooted;
    public final String osCodeName;
    public final String osRelease;

    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z) {
        if (str != null) {
            this.osRelease = str;
            if (str2 != null) {
                this.osCodeName = str2;
                this.isRooted = z;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        if (this.osRelease.equals(osData.osRelease()) && this.osCodeName.equals(osData.osCodeName()) && this.isRooted == osData.isRooted()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int hashCode = (((this.osRelease.hashCode() ^ 1000003) * 1000003) ^ this.osCodeName.hashCode()) * 1000003;
        if (this.isRooted) {
            r1 = 1231;
        } else {
            r1 = 1237;
        }
        return hashCode ^ r1;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final boolean isRooted() {
        return this.isRooted;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String osCodeName() {
        return this.osCodeName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData
    public final String osRelease() {
        return this.osRelease;
    }

    public final String toString() {
        return "OsData{osRelease=" + this.osRelease + ", osCodeName=" + this.osCodeName + ", isRooted=" + this.isRooted + "}";
    }
}
