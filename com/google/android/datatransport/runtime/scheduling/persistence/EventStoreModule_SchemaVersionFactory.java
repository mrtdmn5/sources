package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return Integer.valueOf(SchemaManager.SCHEMA_VERSION);
    }
}
