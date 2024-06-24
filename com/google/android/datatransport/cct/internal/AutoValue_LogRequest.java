package com.google.android.datatransport.cct.internal;

import java.util.List;

/* loaded from: classes3.dex */
public final class AutoValue_LogRequest extends LogRequest {
    public final ClientInfo clientInfo;
    public final List<LogEvent> logEvents;
    public final Integer logSource;
    public final String logSourceName;
    public final QosTier qosTier;
    public final long requestTimeMs;
    public final long requestUptimeMs;

    public AutoValue_LogRequest() {
        throw null;
    }

    public AutoValue_LogRequest(long j, long j2, ClientInfo clientInfo, Integer num, String str, List list, QosTier qosTier) {
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = clientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier;
    }

    public final boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.requestTimeMs == logRequest.getRequestTimeMs() && this.requestUptimeMs == logRequest.getRequestUptimeMs() && ((clientInfo = this.clientInfo) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.logSource) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.logSourceName) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.logEvents) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier = this.qosTier;
            if (qosTier == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final List<LogEvent> getLogEvents() {
        return this.logEvents;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final Integer getLogSource() {
        return this.logSource;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final String getLogSourceName() {
        return this.logSourceName;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final QosTier getQosTier() {
        return this.qosTier;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public final long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int r0 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        int r2 = 0;
        ClientInfo clientInfo = this.clientInfo;
        if (clientInfo == null) {
            hashCode = 0;
        } else {
            hashCode = clientInfo.hashCode();
        }
        int r02 = (r0 ^ hashCode) * 1000003;
        Integer num = this.logSource;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int r03 = (r02 ^ hashCode2) * 1000003;
        String str = this.logSourceName;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int r04 = (r03 ^ hashCode3) * 1000003;
        List<LogEvent> list = this.logEvents;
        if (list == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list.hashCode();
        }
        int r05 = (r04 ^ hashCode4) * 1000003;
        QosTier qosTier = this.qosTier;
        if (qosTier != null) {
            r2 = qosTier.hashCode();
        }
        return r05 ^ r2;
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + this.qosTier + "}";
    }
}
