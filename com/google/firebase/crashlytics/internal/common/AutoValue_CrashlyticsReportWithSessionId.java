package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {
    public final CrashlyticsReport report;
    public final File reportFile;
    public final String sessionId;

    public AutoValue_CrashlyticsReportWithSessionId(AutoValue_CrashlyticsReport autoValue_CrashlyticsReport, String str, File file) {
        this.report = autoValue_CrashlyticsReport;
        if (str != null) {
            this.sessionId = str;
            this.reportFile = file;
            return;
        }
        throw new NullPointerException("Null sessionId");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        if (this.report.equals(crashlyticsReportWithSessionId.getReport()) && this.sessionId.equals(crashlyticsReportWithSessionId.getSessionId()) && this.reportFile.equals(crashlyticsReportWithSessionId.getReportFile())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final CrashlyticsReport getReport() {
        return this.report;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final File getReportFile() {
        return this.reportFile;
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId
    public final String getSessionId() {
        return this.sessionId;
    }

    public final int hashCode() {
        return ((((this.report.hashCode() ^ 1000003) * 1000003) ^ this.sessionId.hashCode()) * 1000003) ^ this.reportFile.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.report + ", sessionId=" + this.sessionId + ", reportFile=" + this.reportFile + "}";
    }
}
