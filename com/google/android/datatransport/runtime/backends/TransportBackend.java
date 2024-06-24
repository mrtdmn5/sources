package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EventInternal;

/* loaded from: classes3.dex */
public interface TransportBackend {
    AutoValue_EventInternal decorate(EventInternal eventInternal);

    AutoValue_BackendResponse send(AutoValue_BackendRequest autoValue_BackendRequest);
}
