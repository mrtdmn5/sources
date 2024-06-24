package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class UptimeClock implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    public final long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
