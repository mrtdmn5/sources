package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes3.dex */
public abstract class LogRequest {
    public abstract ClientInfo getClientInfo();

    public abstract List<LogEvent> getLogEvents();

    public abstract Integer getLogSource();

    public abstract String getLogSourceName();

    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();
}
