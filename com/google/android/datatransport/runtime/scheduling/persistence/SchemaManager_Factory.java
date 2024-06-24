package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SchemaManager_Factory implements Factory<SchemaManager> {
    public final Provider<Context> contextProvider;
    public final Provider<String> dbNameProvider;
    public final Provider<Integer> schemaVersionProvider;

    public SchemaManager_Factory(Provider provider) {
        EventStoreModule_DbNameFactory eventStoreModule_DbNameFactory = EventStoreModule_DbNameFactory.InstanceHolder.INSTANCE;
        EventStoreModule_SchemaVersionFactory eventStoreModule_SchemaVersionFactory = EventStoreModule_SchemaVersionFactory.InstanceHolder.INSTANCE;
        this.contextProvider = provider;
        this.dbNameProvider = eventStoreModule_DbNameFactory;
        this.schemaVersionProvider = eventStoreModule_SchemaVersionFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SchemaManager(this.contextProvider.get(), this.dbNameProvider.get(), this.schemaVersionProvider.get().intValue());
    }
}
