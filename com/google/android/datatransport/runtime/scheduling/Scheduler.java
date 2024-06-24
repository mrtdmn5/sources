package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;

/* loaded from: classes3.dex */
public interface Scheduler {
    void schedule(TransportScheduleCallback transportScheduleCallback, AutoValue_EventInternal autoValue_EventInternal, AutoValue_TransportContext autoValue_TransportContext);
}
