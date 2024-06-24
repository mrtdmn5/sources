package com.google.android.datatransport.runtime.time;

/* loaded from: classes3.dex */
public final class WallTimeClock implements Clock {
    @Override // com.google.android.datatransport.runtime.time.Clock
    public final long getTime() {
        return System.currentTimeMillis();
    }
}
