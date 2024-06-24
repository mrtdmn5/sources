package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {
    public final Provider<Context> applicationContextProvider;
    public final Provider<CreationContextFactory> creationContextFactoryProvider;

    public MetadataBackendRegistry_Factory(InstanceFactory instanceFactory, CreationContextFactory_Factory creationContextFactory_Factory) {
        this.applicationContextProvider = instanceFactory;
        this.creationContextFactoryProvider = creationContextFactory_Factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new MetadataBackendRegistry(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }
}
