package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes3.dex */
public abstract class BatchedLogRequest {
    public abstract List<LogRequest> getLogRequests();
}
