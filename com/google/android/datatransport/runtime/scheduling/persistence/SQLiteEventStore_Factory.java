package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {
    public final Provider<Clock> clockProvider;
    public final Provider<EventStoreConfig> configProvider;
    public final Provider<String> packageNameProvider;
    public final Provider<SchemaManager> schemaManagerProvider;
    public final Provider<Clock> wallClockProvider;

    public SQLiteEventStore_Factory(Provider provider, Provider provider2) {
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.InstanceHolder.INSTANCE;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.InstanceHolder.INSTANCE;
        EventStoreModule_StoreConfigFactory eventStoreModule_StoreConfigFactory = EventStoreModule_StoreConfigFactory.InstanceHolder.INSTANCE;
        this.wallClockProvider = timeModule_EventClockFactory;
        this.clockProvider = timeModule_UptimeClockFactory;
        this.configProvider = eventStoreModule_StoreConfigFactory;
        this.schemaManagerProvider = provider;
        this.packageNameProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Clock clock = this.wallClockProvider.get();
        Clock clock2 = this.clockProvider.get();
        EventStoreConfig eventStoreConfig = this.configProvider.get();
        return new SQLiteEventStore(clock, clock2, eventStoreConfig, this.schemaManagerProvider.get(), this.packageNameProvider);
    }
}
