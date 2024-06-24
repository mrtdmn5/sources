package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class TimeModule_EventClockFactory implements Factory<Clock> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new WallTimeClock();
    }
}
