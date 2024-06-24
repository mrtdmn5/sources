package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
/* loaded from: classes3.dex */
public abstract class HeartBeatResult {
    public abstract List<String> getUsedDates();

    public abstract String getUserAgent();
}
