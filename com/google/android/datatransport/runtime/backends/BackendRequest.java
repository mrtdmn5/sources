package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class BackendRequest {
    public abstract Iterable<EventInternal> getEvents();

    public abstract byte[] getExtras();
}
