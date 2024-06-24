package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = EventStoreConfig.DEFAULT;
        if (autoValue_EventStoreConfig != null) {
            return autoValue_EventStoreConfig;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
