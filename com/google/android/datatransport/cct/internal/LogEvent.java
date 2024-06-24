package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class LogEvent {

    @AutoValue.Builder
    /* loaded from: classes3.dex */
    public static abstract class Builder {
    }

    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    public abstract byte[] getSourceExtension();

    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();
}
