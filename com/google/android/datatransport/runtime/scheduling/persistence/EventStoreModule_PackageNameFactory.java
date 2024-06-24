package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    public final Provider<Context> contextProvider;

    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        String packageName = this.contextProvider.get().getPackageName();
        if (packageName != null) {
            return packageName;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
