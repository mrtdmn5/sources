package com.google.firebase;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class StartupTime {
    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();
}
