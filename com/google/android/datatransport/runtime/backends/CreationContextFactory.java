package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes3.dex */
public final class CreationContextFactory {
    public final Context applicationContext;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public CreationContextFactory(Context context, Clock clock, Clock clock2) {
        this.applicationContext = context;
        this.wallClock = clock;
        this.monotonicClock = clock2;
    }
}
