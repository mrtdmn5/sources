package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MetadataBackendRegistry implements BackendRegistry {
    public final BackendFactoryProvider backendFactoryProvider;
    public final HashMap backends;
    public final CreationContextFactory creationContextFactory;

    /* loaded from: classes3.dex */
    public static class BackendFactoryProvider {
        public final Context applicationContext;
        public Map<String, String> backendProviders = null;

        public BackendFactoryProvider(Context context) {
            this.applicationContext = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.google.android.datatransport.runtime.backends.BackendFactory get(java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 253
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.MetadataBackendRegistry.BackendFactoryProvider.get(java.lang.String):com.google.android.datatransport.runtime.backends.BackendFactory");
        }
    }

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        BackendFactoryProvider backendFactoryProvider = new BackendFactoryProvider(context);
        this.backends = new HashMap();
        this.backendFactoryProvider = backendFactoryProvider;
        this.creationContextFactory = creationContextFactory;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendRegistry
    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        BackendFactory backendFactory = this.backendFactoryProvider.get(str);
        if (backendFactory == null) {
            return null;
        }
        CreationContextFactory creationContextFactory = this.creationContextFactory;
        TransportBackend create = backendFactory.create(new AutoValue_CreationContext(creationContextFactory.applicationContext, creationContextFactory.wallClock, creationContextFactory.monotonicClock, str));
        this.backends.put(str, create);
        return create;
    }
}
