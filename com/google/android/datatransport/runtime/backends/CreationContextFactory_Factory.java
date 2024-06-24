package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {
    public final Provider<Context> applicationContextProvider;
    public final Provider<Clock> monotonicClockProvider;
    public final Provider<Clock> wallClockProvider;

    public CreationContextFactory_Factory(InstanceFactory instanceFactory) {
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.InstanceHolder.INSTANCE;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE;
        this.applicationContextProvider = instanceFactory;
        this.wallClockProvider = timeModule_EventClockFactory;
        this.monotonicClockProvider = timeModule_UptimeClockFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new CreationContextFactory(this.applicationContextProvider.get(), this.wallClockProvider.get(), this.monotonicClockProvider.get());
    }
}
