package com.google.firebase.crashlytics.internal.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {
    public final ImmutableList<CrashlyticsReport.FilesPayload.File> files;
    public final String orgId;

    public AutoValue_CrashlyticsReport_FilesPayload() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_FilesPayload(ImmutableList immutableList, String str) {
        this.files = immutableList;
        this.orgId = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.files.equals(filesPayload.getFiles())) {
            String str = this.orgId;
            if (str == null) {
                if (filesPayload.getOrgId() == null) {
                    return true;
                }
            } else if (str.equals(filesPayload.getOrgId())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public final ImmutableList<CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.files;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload
    public final String getOrgId() {
        return this.orgId;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.files.hashCode() ^ 1000003) * 1000003;
        String str = this.orgId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.files);
        sb.append(", orgId=");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.orgId, "}");
    }
}
