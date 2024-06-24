package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.ExecutionModule_ExecutorFactory;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {
    public Provider<Executor> executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.InstanceHolder.INSTANCE);
    public Provider metadataBackendRegistryProvider;
    public Provider<SQLiteEventStore> sQLiteEventStoreProvider;
    public SchemaManager_Factory schemaManagerProvider;
    public InstanceFactory setApplicationContextProvider;
    public Provider<TransportRuntime> transportRuntimeProvider;

    public DaggerTransportRuntimeComponent(Context context) {
        if (context != null) {
            InstanceFactory instanceFactory = new InstanceFactory(context);
            this.setApplicationContextProvider = instanceFactory;
            this.metadataBackendRegistryProvider = DoubleCheck.provider(new MetadataBackendRegistry_Factory(instanceFactory, new CreationContextFactory_Factory(instanceFactory)));
            InstanceFactory instanceFactory2 = this.setApplicationContextProvider;
            this.schemaManagerProvider = new SchemaManager_Factory(instanceFactory2);
            Provider<SQLiteEventStore> provider = DoubleCheck.provider(new SQLiteEventStore_Factory(this.schemaManagerProvider, DoubleCheck.provider(new EventStoreModule_PackageNameFactory(instanceFactory2))));
            this.sQLiteEventStoreProvider = provider;
            SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactory = new SchedulingConfigModule_ConfigFactory();
            InstanceFactory instanceFactory3 = this.setApplicationContextProvider;
            SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(instanceFactory3, provider, schedulingConfigModule_ConfigFactory);
            Provider<Executor> provider2 = this.executorProvider;
            Provider provider3 = this.metadataBackendRegistryProvider;
            this.transportRuntimeProvider = DoubleCheck.provider(new TransportRuntime_Factory(new DefaultScheduler_Factory(provider2, provider3, schedulingModule_WorkSchedulerFactory, provider, provider), new Uploader_Factory(instanceFactory3, provider3, provider, schedulingModule_WorkSchedulerFactory, provider2, provider, provider), new WorkInitializer_Factory(provider2, provider, schedulingModule_WorkSchedulerFactory, provider)));
            return;
        }
        throw new NullPointerException("instance cannot be null");
    }
}
