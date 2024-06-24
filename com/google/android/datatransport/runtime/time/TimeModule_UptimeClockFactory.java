package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new UptimeClock();
    }
}
