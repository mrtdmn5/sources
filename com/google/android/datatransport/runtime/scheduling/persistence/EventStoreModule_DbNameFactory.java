package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class EventStoreModule_DbNameFactory implements Factory<String> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();
    }

    @Override // javax.inject.Provider
    public final /* bridge */ /* synthetic */ Object get() {
        return "com.google.android.datatransport.events";
    }
}
