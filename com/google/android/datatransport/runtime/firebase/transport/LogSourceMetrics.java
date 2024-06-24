package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class LogSourceMetrics {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final List<LogEventDropped> log_event_dropped_;
    public final String log_source_;

    static {
        Collections.unmodifiableList(new ArrayList());
    }

    public LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.log_source_ = str;
        this.log_event_dropped_ = list;
    }
}
