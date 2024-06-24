package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class AutoValue_LogEvent extends LogEvent {
    public final Integer eventCode;
    public final long eventTimeMs;
    public final long eventUptimeMs;
    public final NetworkConnectionInfo networkConnectionInfo;
    public final byte[] sourceExtension;
    public final String sourceExtensionJsonProto3;
    public final long timezoneOffsetSeconds;

    /* loaded from: classes3.dex */
    public static final class Builder extends LogEvent.Builder {
        public Integer eventCode;
        public Long eventTimeMs;
        public Long eventUptimeMs;
        public NetworkConnectionInfo networkConnectionInfo;
        public byte[] sourceExtension;
        public String sourceExtensionJsonProto3;
        public Long timezoneOffsetSeconds;
    }

    public AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo) {
        this.eventTimeMs = j;
        this.eventCode = num;
        this.eventUptimeMs = j2;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j3;
        this.networkConnectionInfo = networkConnectionInfo;
    }

    public final boolean equals(Object obj) {
        Integer num;
        byte[] sourceExtension;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.eventTimeMs == logEvent.getEventTimeMs() && ((num = this.eventCode) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.eventUptimeMs == logEvent.getEventUptimeMs()) {
            if (logEvent instanceof AutoValue_LogEvent) {
                sourceExtension = ((AutoValue_LogEvent) logEvent).sourceExtension;
            } else {
                sourceExtension = logEvent.getSourceExtension();
            }
            if (Arrays.equals(this.sourceExtension, sourceExtension) && ((str = this.sourceExtensionJsonProto3) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.timezoneOffsetSeconds == logEvent.getTimezoneOffsetSeconds()) {
                NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
                if (networkConnectionInfo == null) {
                    if (logEvent.getNetworkConnectionInfo() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final Integer getEventCode() {
        return this.eventCode;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public final long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        long j = this.eventTimeMs;
        int r0 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        int r3 = 0;
        Integer num = this.eventCode;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r02 = (r0 ^ hashCode) * 1000003;
        long j2 = this.eventUptimeMs;
        int hashCode3 = (((r02 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int r03 = (hashCode3 ^ hashCode2) * 1000003;
        long j3 = this.timezoneOffsetSeconds;
        int r04 = (r03 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        if (networkConnectionInfo != null) {
            r3 = networkConnectionInfo.hashCode();
        }
        return r04 ^ r3;
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.eventTimeMs + ", eventCode=" + this.eventCode + ", eventUptimeMs=" + this.eventUptimeMs + ", sourceExtension=" + Arrays.toString(this.sourceExtension) + ", sourceExtensionJsonProto3=" + this.sourceExtensionJsonProto3 + ", timezoneOffsetSeconds=" + this.timezoneOffsetSeconds + ", networkConnectionInfo=" + this.networkConnectionInfo + "}";
    }
}
