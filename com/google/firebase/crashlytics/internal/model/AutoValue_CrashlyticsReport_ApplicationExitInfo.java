package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {
    public final ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
    public final int importance;
    public final int pid;
    public final String processName;
    public final long pss;
    public final int reasonCode;
    public final long rss;
    public final long timestamp;
    public final String traceFile;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {
        public ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> buildIdMappingForArch;
        public Integer importance;
        public Integer pid;
        public String processName;
        public Long pss;
        public Integer reasonCode;
        public Long rss;
        public Long timestamp;
        public String traceFile;

        public final AutoValue_CrashlyticsReport_ApplicationExitInfo build() {
            String str;
            if (this.pid == null) {
                str = " pid";
            } else {
                str = "";
            }
            if (this.processName == null) {
                str = str.concat(" processName");
            }
            if (this.reasonCode == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " reasonCode");
            }
            if (this.importance == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " importance");
            }
            if (this.pss == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " pss");
            }
            if (this.rss == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " rss");
            }
            if (this.timestamp == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " timestamp");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), this.rss.longValue(), this.timestamp.longValue(), this.traceFile, this.buildIdMappingForArch);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_ApplicationExitInfo() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_ApplicationExitInfo(int r1, String str, int r3, int r4, long j, long j2, long j3, String str2, ImmutableList immutableList) {
        this.pid = r1;
        this.processName = str;
        this.reasonCode = r3;
        this.importance = r4;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
        this.buildIdMappingForArch = immutableList;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp() && ((str = this.traceFile) != null ? str.equals(applicationExitInfo.getTraceFile()) : applicationExitInfo.getTraceFile() == null)) {
            ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.buildIdMappingForArch;
            if (immutableList == null) {
                if (applicationExitInfo.getBuildIdMappingForArch() == null) {
                    return true;
                }
            } else if (immutableList.equals(applicationExitInfo.getBuildIdMappingForArch())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> getBuildIdMappingForArch() {
        return this.buildIdMappingForArch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getPid() {
        return this.pid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String getProcessName() {
        return this.processName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getPss() {
        return this.pss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final int getReasonCode() {
        return this.reasonCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getRss() {
        return this.rss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo
    public final String getTraceFile() {
        return this.traceFile;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003;
        long j = this.pss;
        int r0 = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.rss;
        int r02 = (r0 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.timestamp;
        int r03 = (r02 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        int r2 = 0;
        String str = this.traceFile;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r04 = (r03 ^ hashCode) * 1000003;
        ImmutableList<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> immutableList = this.buildIdMappingForArch;
        if (immutableList != null) {
            r2 = immutableList.hashCode();
        }
        return r04 ^ r2;
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.pid + ", processName=" + this.processName + ", reasonCode=" + this.reasonCode + ", importance=" + this.importance + ", pss=" + this.pss + ", rss=" + this.rss + ", timestamp=" + this.timestamp + ", traceFile=" + this.traceFile + ", buildIdMappingForArch=" + this.buildIdMappingForArch + "}";
    }
}
